package com.xiaot.factory.dao;

import com.xiaot.factory.entity.po.MenuPo;
import com.xiaot.factory.entity.vo.MenuVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuDao {

    /**
     * 菜单列表
     * @return
     */
    List<MenuVo> menuList(@Param("roleId") Integer roleId);

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
