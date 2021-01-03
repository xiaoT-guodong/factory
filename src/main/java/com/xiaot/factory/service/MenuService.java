package com.xiaot.factory.service;

import com.xiaot.factory.entity.po.MenuPo;

public interface MenuService {

    MenuPo menuList();

    void addMenu(MenuPo menuPo);

    void updateMenu(MenuPo menuPo);

}
