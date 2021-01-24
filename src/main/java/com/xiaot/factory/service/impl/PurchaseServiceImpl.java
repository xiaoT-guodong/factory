package com.xiaot.factory.service.impl;

import com.xiaot.factory.config.exception.CrudException;
import com.xiaot.factory.dao.InventoryDao;
import com.xiaot.factory.dao.PurchaseDao;
import com.xiaot.factory.entity.PageQueryEntity;
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
    public List<PurchaseSalesVo> list(PageQueryEntity pageQueryEntity) {
        return purchaseDao.listPurchase(pageQueryEntity);
    }

    @Override
    public Integer listCount() {
        return purchaseDao.listPurchaseCount();
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

    @Transactional
    @Override
    public void updatePurchase(PurchasePo purchasePo) {
        // 原进货数量
        int purchaseNum = purchaseDao.findPurchaseNum(purchasePo.getId());
        // 原库存数量
        int inventoryNum = inventoryDao.findInventoryNum(purchasePo.getInventoryId());
        // 原数量和修改数量相差数量
        int num = inventoryNum - purchaseNum + purchasePo.getPurchaseNum();
        if(num < 0) {
            throw new CrudException(ErrorEnum.SALES_SURPLUS);
        }
        InventoryPo inventoryPo = new InventoryPo().setId(purchasePo.getInventoryId())
                                                .setInventoryNum(num);
        if(inventoryDao.updateInventory(inventoryPo) < 1) {
            throw new CrudException(ErrorEnum.PURCHASE_INVENTORY_UPDATE);
        }
        if(purchaseDao.updatePurchase(purchasePo) < 1) {
            throw new CrudException(ErrorEnum.PURCHASE_UPDATE);
        }
    }

}
