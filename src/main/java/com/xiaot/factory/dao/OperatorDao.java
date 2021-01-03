package com.xiaot.factory.dao;

import com.xiaot.factory.entity.po.OperatorPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OperatorDao {

    OperatorPo findOperator(@Param("loginName") String loginName, @Param("password") String password);

}
