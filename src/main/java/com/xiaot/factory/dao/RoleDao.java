package com.xiaot.factory.dao;

import com.xiaot.factory.entity.po.RolePo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleDao {

    /**
     * 角色列表
     * @return
     */
    RolePo roleList();

    /**
     * 添加角色
     * @param rolePo
     * @return
     */
    int addRole(RolePo rolePo);

    /**
     * 修改角色
     * @param rolePo
     * @return
     */
    int updateRole(RolePo rolePo);

}
