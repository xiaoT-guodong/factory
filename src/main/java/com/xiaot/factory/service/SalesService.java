package com.xiaot.factory.service;

import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.SalesPo;
import com.xiaot.factory.entity.vo.PurchaseSalesVo;

import java.util.List;

public interface SalesService {

    /**
     * 进库流水
     * @return
     */
    List<PurchaseSalesVo> list(PageQueryEntity pageQueryEntity);

    /**
     * 进库流水条数
     * @return
     */
    Integer listCount();

    /**
     * 添加出货流水
     * @param salesPo
     */
    void addSales(SalesPo salesPo);

    /**
     * 修改出货流水
     * @param salesPo
     */
    void updateSales(SalesPo salesPo);

}
