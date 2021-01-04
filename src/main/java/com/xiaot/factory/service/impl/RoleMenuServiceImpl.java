package com.xiaot.factory.service.impl;

import com.xiaot.factory.dao.RoleMenuDao;
import com.xiaot.factory.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Transactional
    @Override
    public void updateRoleMenu(Integer roleId, String menuIds) {
        roleMenuDao.deleteRoleMenu(roleId);
        if(menuIds == null || "".equals(menuIds)) {
            return;
        }
        String[] menuId = menuIds.split(",");
        roleMenuDao.addRoleMenu(roleId, menuId);
    }

}
