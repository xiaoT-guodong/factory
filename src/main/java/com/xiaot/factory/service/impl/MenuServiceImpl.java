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
        List<MenuPo> menuPos = menuDao.menuList(roleId);
        List<MenuVo> menuVos = new ArrayList<>();
        for (MenuPo menuPo : menuPos) {
            if (menuPo.getPId().equals(0)) {
                MenuVo menuVo = new MenuVo().setId(menuPo.getId())
                                            .setPId(menuPo.getPId())
                                            .setMenuName(menuPo.getMenuName())
                                            .setMenuUrl(menuPo.getMenuUrl())
                                            .setMenuImage(menuPo.getMenuImage());
                menuSetChild(menuPos, menuVo);
                menuVos.add(menuVo);
            }
        }
        return menuVos;
    }

    /**
     * 设置子菜单
     * @param menuPos pid为0的菜单
     * @param menuVo 需要设置子菜单的菜单
     */
    private void menuSetChild(List<MenuPo> menuPos, MenuVo menuVo) {
        List<MenuVo> childVos = new ArrayList<>();
        for (MenuPo childPo : menuPos) {
            if (childPo.getPId().equals(menuVo.getId())) {
                MenuVo childVo = new MenuVo().setId(childPo.getId())
                                            .setPId(childPo.getPId())
                                            .setMenuName(childPo.getMenuName())
                                            .setMenuUrl(childPo.getMenuUrl())
                                            .setMenuImage(childPo.getMenuImage());
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

}
