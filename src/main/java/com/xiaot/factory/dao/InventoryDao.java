package com.xiaot.factory.dao;

import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.InventoryPo;
import com.xiaot.factory.entity.vo.InventorySelectVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryDao {

    /**
     * 库存列表
     * @return
     */
    List<InventoryPo> listInventory(PageQueryEntity pageQueryEntity);

    /**
     * 库存列表条数
     * @return
     */
    Integer listInventoryCount();

    /**
     * 添加进货流水
     * @param inventoryPo
     * @return
     */
    int addInventory(InventoryPo inventoryPo);

    /**
     * 修改进货流水
     * @param inventoryPo
     * @return
     */
    int updateInventory(InventoryPo inventoryPo);

    /**
     * 查询物品剩余库存
     * @param inventoryId
     * @return
     */
    int findInventoryNum(Integer inventoryId);

    /**
     * 库存物品下拉
     * @return
     */
    List<InventorySelectVo> listSelect();

}
