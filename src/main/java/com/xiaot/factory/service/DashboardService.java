package com.xiaot.factory.service;

import java.util.List;
import java.util.Map;

public interface DashboardService {

    /**
     * 购买花销
     * @return
     */
    Map<String, Object> overview();

    /**
     * 物品购买分类花销
     * @return
     */
    List<Map<String, Object>> purchasePie();

    /**
     * 卖出物品分类收入
     * @return
     */
    List<Map<String, Object>> salesPie();

    /**
     * 近一年月售出
     * @return
     */
    Map<String, Object> monthLine();

}
