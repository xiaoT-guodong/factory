package com.xiaot.factory.controller;

import com.xiaot.factory.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.xiaot.factory.util.Result.success;

/**
 * 菜单相关接口
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/list")
    public Map<String, Object> menuList() {
        return success(menuService.menuList());
    }

}
