package com.xiaot.factory.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface DashboardDao {

    /**
     * 购买花销
     * @return
     */
    Map<String, Object> overview();

}
