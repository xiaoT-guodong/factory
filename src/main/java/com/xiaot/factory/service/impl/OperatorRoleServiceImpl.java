package com.xiaot.factory.service.impl;

import com.xiaot.factory.dao.OperatorRoleDao;
import com.xiaot.factory.service.OperatorRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OperatorRoleServiceImpl implements OperatorRoleService {

    @Autowired
    private OperatorRoleDao operatorRoleDao;

    @Override
    public List<String> findHasRoles(Integer operatorId) {
        return operatorRoleDao.findHasRoles(operatorId);
    }

    @Transactional
    @Override
    public void updateOperatorRole(Integer roleId, String menuIds) {
        operatorRoleDao.deleteOperatorRole(roleId);
        if(menuIds == null || "".equals(menuIds)) {
            return;
        }
        String[] menuId = menuIds.split(",");
        operatorRoleDao.addOperatorRole(roleId, menuId);
    }

}
