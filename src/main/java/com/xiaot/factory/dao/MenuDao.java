package com.xiaot.factory.dao;

import com.xiaot.factory.entity.po.MenuPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuDao {

    MenuPo menuList();

}
