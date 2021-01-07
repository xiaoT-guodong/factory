package com.xiaot.factory.service;

import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.InventoryPo;
import com.xiaot.factory.entity.vo.InventorySelectVo;

import java.util.List;

public interface InventoryService {

    /**
     * 库存列表
     * @return
     */
    List<InventoryPo> list(PageQueryEntity pageQueryEntity);

    /**
     * 库存列表条数
     * @return
     */
    Integer listCount();

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

    /**
     * 库存物品下拉
     * @return
     */
    List<InventorySelectVo> listSelect();

}
