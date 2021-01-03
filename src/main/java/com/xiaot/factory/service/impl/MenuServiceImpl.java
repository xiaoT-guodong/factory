package com.xiaot.factory.service.impl;

import com.xiaot.factory.dao.MenuDao;
import com.xiaot.factory.entity.po.MenuPo;
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

}
