package com.xiaot.factory.controller;

import com.xiaot.factory.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.xiaot.factory.util.ResultUtil.success;

/**
 * 主页图表
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/overview")
    public Map<String, Object> overview() {
        return success(dashboardService.overview());
    }

    @GetMapping("/purchasePie")
    public Map<String, Object> purchasePie() {
        return success(dashboardService.purchasePie());
    }

    @GetMapping("/salesPie")
    public Map<String, Object> salesPie() {
        return success(dashboardService.salesPie());
    }

    @GetMapping("/monthLine")
    public Map<String, Object> monthLine() {
        return success(dashboardService.monthLine());
    }

}
