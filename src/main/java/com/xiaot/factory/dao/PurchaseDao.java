package com.xiaot.factory.dao;

import com.xiaot.factory.entity.po.PurchasePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseDao {

    /**
     * 进库流水
     * @return
     */
    List<PurchasePo> listPurchase();

    /**
     * 添加进货流水
     * @param purchasePo
     * @return
     */
    int addPurchase(PurchasePo purchasePo);

    /**
     * 修改进货流水
     * @param purchasePo
     * @return
     */
    int updatePurchase(PurchasePo purchasePo);

}
