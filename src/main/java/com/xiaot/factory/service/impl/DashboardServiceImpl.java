package com.xiaot.factory.service.impl;

import com.xiaot.factory.dao.DashboardDao;
import com.xiaot.factory.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardDao dashboardDao;

    @Override
    public Map<String, Object> overview() {
        return dashboardDao.overview();
    }

    @Override
    public List<Map<String, Object>> purchasePie() {
        return dashboardDao.purchasePie();
    }

    @Override
    public List<Map<String, Object>> salesPie() {
        return dashboardDao.salesPie();
    }

    @Override
    public Map<String, Object> monthLine() {
        Map<String, Object> lineData = new HashMap<>();
        Map<String, Object> both = dashboardDao.monthLine();
        lineData.put("purchase", getMapList("purchase", both));
        lineData.put("sales", getMapList("sales", both));
        return lineData;
    }

    private List<Object> getMapList(String prefix, Map<String, Object> data) {
        List<Object> list = new ArrayList<>();
        list.add(data.get(prefix + "Twelve"));
        list.add(data.get(prefix + "Eleven"));
        list.add(data.get(prefix + "Ten"));
        list.add(data.get(prefix + "Nine"));
        list.add(data.get(prefix + "Eight"));
        list.add(data.get(prefix + "Seven"));
        list.add(data.get(prefix + "Six"));
        list.add(data.get(prefix + "Five"));
        list.add(data.get(prefix + "Four"));
        list.add(data.get(prefix + "Three"));
        list.add(data.get(prefix + "Two"));
        list.add(data.get(prefix + "One"));
        return list;
    }
    
}
