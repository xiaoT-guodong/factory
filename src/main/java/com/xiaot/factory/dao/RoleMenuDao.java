package com.xiaot.factory.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleMenuDao {

    /**
     * 删除角色所有权限
     * @param roleId
     * @return
     */
    int deleteRoleMenu(@Param("roleId") Integer roleId);

    /**
     * 添加角色菜单关联
     * @param roleId
     * @param menuIds
     * @return
     */
    int addRoleMenu(@Param("roleId") Integer roleId, @Param("menuIds") String[] menuIds);

}
