package com.xiaot.factory.service.impl;

import com.xiaot.factory.config.exception.CrudException;
import com.xiaot.factory.dao.InventoryDao;
import com.xiaot.factory.dao.SalesDao;
import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.InventoryPo;
import com.xiaot.factory.entity.po.SalesPo;
import com.xiaot.factory.entity.vo.PurchaseSalesVo;
import com.xiaot.factory.enumeration.ErrorEnum;
import com.xiaot.factory.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesDao salesDao;

    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public List<PurchaseSalesVo> list(PageQueryEntity pageQueryEntity) {
        return salesDao.listSales(pageQueryEntity);
    }

    @Override
    public Integer listCount() {
        return salesDao.listSalesCount();
    }

    @Transactional
    @Override
    public void addSales(SalesPo salesPo) {
        Integer inventoryId = salesPo.getInventoryId();
        int existNum = inventoryDao.findInventoryNum(inventoryId);
        int surplus = existNum - salesPo.getSalesNum();
        if (surplus < 0) {
            throw new CrudException(ErrorEnum.SALES_SURPLUS);
        }
        if(salesDao.addSales(salesPo) < 1) {
            throw new CrudException(ErrorEnum.SALES_ADD);
        }
        InventoryPo inventoryPo = new InventoryPo().setId(inventoryId)
                                                .setInventoryNum(surplus);
        if(inventoryDao.updateInventory(inventoryPo) < 1) {
            throw new CrudException(ErrorEnum.SALES_INVENTORY_UPDATE);
        }
    }

    @Override
    public void updateSales(SalesPo salesPo) {
        if(salesDao.updateSales(salesPo) < 1) {
            throw new CrudException(ErrorEnum.SALES_UPDATE);
        }
    }

}
