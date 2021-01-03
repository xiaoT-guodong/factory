package com.xiaot.factory.dao;

import com.xiaot.factory.entity.po.MenuPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuDao {

    /**
     * 菜单列表
     * @return
     */
    MenuPo menuList();

    /**
     * 添加菜单
     * @param menuPo
     * @return
     */
    int addMenu(MenuPo menuPo);

    /**
     * 修改菜单
     * @param menuPo
     * @return
     */
    int updateMenu(MenuPo menuPo);

}
