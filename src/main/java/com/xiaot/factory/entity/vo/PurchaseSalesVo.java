package com.xiaot.factory.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseSalesVo {

    private Integer id;

    /**
     * 物品名称
     */
    private String name;

    /**
     * 物品数量
     */
    private Integer num;

    /**
     * 物品单价
     */
    private BigDecimal price;

    /**
     * 采购总价
     */
    private BigDecimal total;

    /**
     * 物品描述
     */
    private String comment;

}
