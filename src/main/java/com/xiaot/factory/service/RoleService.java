package com.xiaot.factory.service;

import com.xiaot.factory.entity.po.RolePo;

public interface RoleService {

    /**
     * 角色列表
     * @return
     */
    RolePo roleList();

    /**
     * 添加角色
     * @param rolePo
     */
    void addRole(RolePo rolePo);

    /**
     * 修改角色
     * @param rolePo
     */
    void updateRole(RolePo rolePo);

}
