package com.xiaot.factory.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 进库
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasePo {

    private Integer id;

    /**
     * 采购物品名称
     */
    private String purchaseName;

    /**
     * 采购数量
     */
    private Integer purchaseNum;

    /**
     * 采购单价
     */
    private BigDecimal purchasePrice;

    /**
     * 采购总价
     */
    private BigDecimal purchaseTotal;

    /**
     * 物品描述
     */
    private String purchaseComment;

    /**
     * 采购时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
