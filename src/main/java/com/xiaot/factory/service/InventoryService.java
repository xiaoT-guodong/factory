package com.xiaot.factory.service;

import com.xiaot.factory.entity.po.InventoryPo;

import java.util.List;

public interface InventoryService {

    /**
     * 库存列表
     * @return
     */
    List<InventoryPo> list();

    /**
     * 添加库存物品
     * @param inventoryPo
     */
    void addInventory(InventoryPo inventoryPo);

    /**
     * 修改库存物品
     * @param inventoryPo
     */
    void updateInventory(InventoryPo inventoryPo);

}
