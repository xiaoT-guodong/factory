package com.xiaot.factory.service;

public interface RoleMenuService {

    /**
     * 修改角色菜单关联
     * @param roleId
     * @param menuIds
     */
    void updateRoleMenu(Integer roleId, String menuIds);

}
