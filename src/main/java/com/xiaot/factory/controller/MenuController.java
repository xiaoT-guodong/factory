package com.xiaot.factory.controller;

import com.xiaot.factory.entity.po.MenuPo;
import com.xiaot.factory.entity.po.OperatorPo;
import com.xiaot.factory.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.xiaot.factory.util.ResultUtil.success;

/**
 * 菜单相关接口
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public Map<String, Object> menuList(HttpServletRequest request) {
        OperatorPo loginUser = (OperatorPo) request.getSession().getAttribute("loginUser");
        return success(menuService.menuList(loginUser.getRoleId()));
    }

    @PostMapping
    public Map<String, Object> add(MenuPo menuPo) {
        menuService.addMenu(menuPo);
        return success("添加成功");
    }

    @PutMapping
    public Map<String, Object> update(MenuPo menuPo) {
        menuService.updateMenu(menuPo);
        return success("修改成功");
    }

    @GetMapping("/permission")
    public Map<String, Object> menuListPermission(HttpServletRequest request) {
        OperatorPo loginUser = (OperatorPo) request.getSession().getAttribute("loginUser");
        return success(menuService.menuListPermission(loginUser.getRoleId()));
    }

}
