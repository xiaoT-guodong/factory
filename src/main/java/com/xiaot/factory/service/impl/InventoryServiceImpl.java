package com.xiaot.factory.service.impl;

import com.xiaot.factory.config.exception.CrudException;
import com.xiaot.factory.dao.InventoryDao;
import com.xiaot.factory.entity.QueryEntity;
import com.xiaot.factory.entity.po.InventoryPo;
import com.xiaot.factory.entity.vo.InventorySelectVo;
import com.xiaot.factory.enumeration.ErrorEnum;
import com.xiaot.factory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public List<InventoryPo> list(QueryEntity query) {
        return inventoryDao.listInventory(query);
    }

    @Override
    public Integer listCount() {
        return inventoryDao.listInventoryCount();
    }

    @Override
    public void addInventory(InventoryPo inventoryPo) {
        if(inventoryDao.addInventory(inventoryPo) < 1) {
            throw new CrudException(ErrorEnum.INVENTORY_ADD);
        }
    }

    @Override
    public void updateInventory(InventoryPo inventoryPo) {
        if(inventoryDao.updateInventory(inventoryPo) < 1) {
            throw new CrudException(ErrorEnum.INVENTORY_UPDATE);
        }
    }

    @Override
    public List<InventorySelectVo> listSelect() {
        return inventoryDao.listSelect();
    }

}
