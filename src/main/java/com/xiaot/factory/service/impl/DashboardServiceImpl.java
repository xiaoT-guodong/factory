package com.xiaot.factory.service.impl;

import com.xiaot.factory.dao.DashboardDao;
import com.xiaot.factory.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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
        List<Map<String, Object>> purchase = dashboardDao.purchaseMonthLine();
        List<Map<String, Object>> sales = dashboardDao.salesMonthLine();
        lineData.put("purchase", getLineDate(purchase));
        lineData.put("sales", getLineDate(sales));
        return lineData;
    }

    private List<Object> getLineDate(List<Map<String, Object>> data) {
        if (data == null) {
            data = Collections.emptyList();
        }
        List<Object> pays = new ArrayList<>();
        all : for (int i = 11; i >= 0; i--) {
            // 遍历有花费的月份，并加到pays中
            for (Map<String, Object> has : data) {
                if (getFormatDate(i).equals(has.get("date").toString())) {
                    pays.add(has.get("money").toString());
                    continue all;
                }
            }
            // 为没有花费的月份添加值
            pays.add("0");
        }
        return pays;
    }

    private String getFormatDate(Integer subMonth) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -subMonth);
        return sdf.format(calendar.getTime());
    }
    
}
