package com.xiaot.factory.dao;

import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.PurchasePo;
import com.xiaot.factory.entity.vo.PurchaseSalesVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PurchaseDao {

    /**
     * 进库流水
     * @return
     */
    List<PurchaseSalesVo> listPurchase(PageQueryEntity pageQueryEntity);

    /**
     * 进库流水条数
     * @return
     */
    Integer listPurchaseCount();

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
