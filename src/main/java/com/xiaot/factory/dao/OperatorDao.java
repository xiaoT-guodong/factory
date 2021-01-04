package com.xiaot.factory.dao;

import com.xiaot.factory.entity.po.OperatorPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OperatorDao {

    /**
     * 查找操作员
     * @param loginName
     * @param password
     * @return
     */
    OperatorPo findOperator(@Param("loginName") String loginName, @Param("password") String password);

    /**
     * 查找登录账号是否存在
     * @param loginName
     * @return
     */
    int loginNameExist(@Param("id") Integer id, @Param("loginName") String loginName);

    /**
     * 添加操作员
     * @param operatorPo
     * @return
     */
    int addOperator(OperatorPo operatorPo);

    /**
     * 修改操作员
     * @param operatorPo
     * @return
     */
    int updateOperator(OperatorPo operatorPo);

}
