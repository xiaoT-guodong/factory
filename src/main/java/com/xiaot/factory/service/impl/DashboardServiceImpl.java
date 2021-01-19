package com.xiaot.factory.service.impl;

import com.xiaot.factory.dao.DashboardDao;
import com.xiaot.factory.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardDao dashboardDao;

    @Override
    public Map<String, Object> overview() {
        return dashboardDao.overview();
    }

}
