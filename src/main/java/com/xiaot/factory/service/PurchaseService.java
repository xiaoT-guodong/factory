package com.xiaot.factory.service;

import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.PurchasePo;
import com.xiaot.factory.entity.vo.PurchaseSalesVo;

import java.util.List;

public interface PurchaseService {

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
     * 添加进货流水
     * @param purchasePo
     */
    void addPurchase(PurchasePo purchasePo);

    /**
     * 修改进货流水
     * @param purchasePo
     */
    void updatePurchase(PurchasePo purchasePo);

}
