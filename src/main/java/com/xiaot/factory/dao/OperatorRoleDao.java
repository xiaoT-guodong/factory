package com.xiaot.factory.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OperatorRoleDao {

    /**
     * 查找操作员拥有的角色
     * @param operatorId
     * @return
     */
    List<String> findHasRoles(@Param("operatorId") Integer operatorId);

    /**
     * 删除操作员所有角色
     * @param operatorId
     * @return
     */
    int deleteOperatorRole(@Param("operatorId") Integer operatorId);

    /**
     * 添加角色菜单关联
     * @param operatorId
     * @param roleIds
     * @return
     */
    int addOperatorRole(@Param("operatorId") Integer operatorId, @Param("roleIds") String[] roleIds);

}
