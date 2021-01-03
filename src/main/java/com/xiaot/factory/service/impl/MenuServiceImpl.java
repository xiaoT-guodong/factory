package com.xiaot.factory.service.impl;

import com.xiaot.factory.config.exception.CrudException;
import com.xiaot.factory.dao.MenuDao;
import com.xiaot.factory.entity.po.MenuPo;
import com.xiaot.factory.enumeration.ErrorEnum;
import com.xiaot.factory.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public MenuPo menuList() {
        return menuDao.menuList();
    }

    @Override
    public void addMenu(MenuPo menuPo) {
        if(menuDao.addMenu(menuPo) < 1) {
            throw new CrudException(ErrorEnum.MENU_ADD);
        }
    }

    @Override
    public void updateMenu(MenuPo menuPo) {
        if(menuDao.updateMenu(menuPo) < 1) {
            throw new CrudException(ErrorEnum.MENU_UPDATE);
        }
    }

}
