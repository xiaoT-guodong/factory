package com.xiaot.factory.service;

import com.xiaot.factory.entity.po.MenuPo;
import com.xiaot.factory.entity.vo.MenuVo;

import java.util.List;

public interface MenuService {

    /**
     * 菜单列表
     * @return
     */
    List<MenuVo> menuList(Integer roleId);

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

    /**
     * 拥有的菜单列表
     * @return
     */
    List<MenuVo> menuListPermission(Integer roleId);

}
