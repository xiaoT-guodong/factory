package com.xiaot.factory.service.impl;

import com.xiaot.factory.config.exception.CrudException;
import com.xiaot.factory.dao.InventoryDao;
import com.xiaot.factory.dao.PurchaseDao;
import com.xiaot.factory.entity.po.InventoryPo;
import com.xiaot.factory.entity.po.PurchasePo;
import com.xiaot.factory.entity.vo.PurchaseSalesVo;
import com.xiaot.factory.enumeration.ErrorEnum;
import com.xiaot.factory.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDao purchaseDao;

    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public List<PurchaseSalesVo> list() {
        return purchaseDao.listPurchase();
    }

    @Transactional
    @Override
    public void addPurchase(PurchasePo purchasePo) {
        if(purchaseDao.addPurchase(purchasePo) < 1) {
            throw new CrudException(ErrorEnum.PURCHASE_ADD);
        }
        Integer inventoryId = purchasePo.getInventoryId();
        int existNum = inventoryDao.findInventoryNum(inventoryId);
        InventoryPo inventoryPo = new InventoryPo().setId(inventoryId)
                                                .setInventoryNum(existNum + purchasePo.getPurchaseNum());
        if(inventoryDao.updateInventory(inventoryPo) < 1) {
            throw new CrudException(ErrorEnum.PURCHASE_INVENTORY_UPDATE);
        }
    }

    @Override
    public void updatePurchase(PurchasePo purchasePo) {
        if(purchaseDao.updatePurchase(purchasePo) < 1) {
            throw new CrudException(ErrorEnum.PURCHASE_UPDATE);
        }
    }

}
