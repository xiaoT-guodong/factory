package com.xiaot.factory.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiaot.factory.util.DateUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 出库
 */
@Data
public class SalesPo {

    private Integer id;
    
    /**
     * 库存物品id
     */
    private Integer inventoryId;

    /**
     * 卖出数量
     */
    private Integer salesNum;

    /**
     * 卖出单价
     */
    private BigDecimal salesPrice;

    /**
     * 卖出总价
     */
    private BigDecimal salesTotal;

    /**
     * 卖出时间
     */
    @JsonFormat(pattern = DateUtil.PATTERN, timezone = DateUtil.TIMEZONE)
    private Date createTime;

}
