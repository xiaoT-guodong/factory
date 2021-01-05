package com.xiaot.factory.service;

import com.xiaot.factory.entity.po.PurchasePo;
import com.xiaot.factory.entity.vo.PurchaseVo;

import java.util.List;

public interface PurchaseService {

    /**
     * 进库流水
     * @return
     */
    List<PurchaseVo> list();

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
