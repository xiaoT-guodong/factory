package com.xiaot.factory.service;

import com.xiaot.factory.entity.po.MenuPo;

public interface MenuService {

    /**
     * 菜单列表
     * @return
     */
    MenuPo menuList();

    /**
     * 添加菜单
     * @param menuPo
     */
    void addMenu(MenuPo menuPo);

    /**
     * 修改菜单
     * @param menuPo
     */
    void updateMenu(MenuPo menuPo);

}
