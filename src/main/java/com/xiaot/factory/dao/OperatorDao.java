package com.xiaot.factory.dao;

import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.OperatorPo;
import com.xiaot.factory.entity.vo.OperatorVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OperatorDao {

    /**
     * 查找操作员
     * @param loginName
     * @param password
     * @return
     */
    OperatorVo findOperator(@Param("loginName") String loginName, @Param("password") String password);

    /**
     * 操作员列表
     * @param pageQueryEntity
     * @return
     */
    List<OperatorPo> listOperator(PageQueryEntity pageQueryEntity);

    /**
     * 操作员列表条数
     * @return
     */
    Integer listCount();

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
