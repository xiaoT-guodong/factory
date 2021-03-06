package com.xiaot.factory.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiaot.factory.util.DateUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 库存
 */
@Data
@NoArgsConstructor
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
    @JsonFormat(pattern = DateUtil.PATTERN, timezone = DateUtil.TIMEZONE)
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = DateUtil.PATTERN, timezone = DateUtil.TIMEZONE)
    private Date updateTime;
    
}
