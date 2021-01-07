package com.xiaot.factory.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiaot.factory.util.DateUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 进库
 */
@Data
public class PurchasePo {

    private Integer id;

    /**
     * 库存物品id
     */
    private Integer inventoryId;

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
     * 采购时间
     */
    @JsonFormat(pattern = DateUtil.PATTERN, timezone = DateUtil.TIMEZONE)
    private Date createTime;

}
