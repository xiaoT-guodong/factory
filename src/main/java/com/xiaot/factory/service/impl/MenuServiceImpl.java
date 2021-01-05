package com.xiaot.factory.service.impl;

import com.xiaot.factory.config.exception.CrudException;
import com.xiaot.factory.dao.MenuDao;
import com.xiaot.factory.entity.po.MenuPo;
import com.xiaot.factory.entity.vo.MenuVo;
import com.xiaot.factory.enumeration.ErrorEnum;
import com.xiaot.factory.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<MenuVo> menuList(Integer roleId) {
        List<MenuVo> menuVos = menuDao.menuList(roleId);
        List<MenuVo> menuList = new ArrayList<>();
        for (MenuVo menuVo : menuVos) {
            if (menuVo.getPId().equals(0)) {
                menuSetChild(menuVos, menuVo);
                menuList.add(menuVo);
            }
        }
        return menuList;
    }

    /**
     * 设置子菜单
     * @param menuPos pid为0的菜单
     * @param menuVo 需要设置子菜单的菜单
     */
    private void menuSetChild(List<MenuVo> menuPos, MenuVo menuVo) {
        List<MenuVo> childVos = new ArrayList<>();
        for (MenuVo childVo : menuPos) {
            if (childVo.getPId().equals(menuVo.getId())) {
                menuSetChild(menuPos, childVo);
                childVos.add(childVo);
            }
        }
        menuVo.setChildren(childVos);
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

    @Override
    public List<MenuVo> menuListPermission(Integer roleId) {
        List<MenuVo> allMenus = menuDao.menuList(null);
        List<MenuVo> menuVos = menuDao.menuList(roleId);
        List<MenuVo> menuList = new ArrayList<>();
        for (MenuVo allMenu : allMenus) {
            for (MenuVo menuVo : menuVos) {
                if (allMenu.equals(menuVo)) {
                    allMenu.setChecked(true);
                }
            }
            if (allMenu.getPId().equals(0)) {
                allMenuSetChild(allMenus, allMenu, menuVos);
                menuList.add(allMenu);
            }
        }
        return menuList;
    }

    /**
     * 设置子菜单同时选中拥有的菜单
     * @param menuVos pid为0的菜单
     * @param menuVo 需要设置子菜单的菜单
     * @param hasMenu 拥有的菜单列表
     */
    private void allMenuSetChild(List<MenuVo> menuVos, MenuVo menuVo, List<MenuVo> hasMenu) {
        List<MenuVo> childVos = new ArrayList<>();
        for (MenuVo childVo : menuVos) {
            for (MenuVo menu : hasMenu) {
                if (childVo.equals(menu)) {
                    childVo.setChecked(true);
                }
            }
            if (childVo.getPId().equals(menuVo.getId())) {
                menuSetChild(menuVos, childVo);
                childVos.add(childVo);
            }
        }
        menuVo.setChildren(childVos);
    }

}
