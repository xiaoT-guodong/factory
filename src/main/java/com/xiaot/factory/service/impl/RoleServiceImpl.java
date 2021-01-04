package com.xiaot.factory.service.impl;

import com.xiaot.factory.config.exception.CrudException;
import com.xiaot.factory.dao.RoleDao;
import com.xiaot.factory.entity.po.RolePo;
import com.xiaot.factory.enumeration.ErrorEnum;
import com.xiaot.factory.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RolePo> roleList() {
        return roleDao.roleList();
    }

    @Override
    public void addRole(RolePo rolePo) {
        if (roleDao.addRole(rolePo) < 1) {
            throw new CrudException(ErrorEnum.ROLE_ADD);
        }
    }

    @Override
    public void updateRole(RolePo rolePo) {
        if (roleDao.updateRole(rolePo) < 1) {
            throw new CrudException(ErrorEnum.ROLE_UPDATE);
        }
    }

}
