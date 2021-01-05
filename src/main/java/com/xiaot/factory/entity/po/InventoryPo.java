package com.xiaot.factory.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 库存
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class InventoryPo {
    
    private Integer id;
    
    /**
     * 商品名称
     */
    private String inventoryName;

    /**
     * 商品数量
     */
    private Integer inventoryNum;

    /**
     * 商品描述
     */
    private String inventoryComment;

    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 修改时间
     */
    private Date updateTime;
    
}
