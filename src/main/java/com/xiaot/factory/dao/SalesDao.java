package com.xiaot.factory.dao;

import com.xiaot.factory.entity.po.SalesPo;
import com.xiaot.factory.entity.vo.PurchaseSalesVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesDao {

    /**
     * 出库流水
     * @return
     */
    List<PurchaseSalesVo> listSales();

    /**
     * 添加出货流水
     * @param salesPo
     * @return
     */
    int addSales(SalesPo salesPo);

    /**
     * 修改出货流水
     * @param salesPo
     * @return
     */
    int updateSales(SalesPo salesPo);

}
