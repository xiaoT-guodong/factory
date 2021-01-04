package com.xiaot.factory.controller;

import com.xiaot.factory.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.xiaot.factory.util.Result.success;

@RestController
@RequestMapping("/roleMenu")
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    @PutMapping
    public Map<String, Object> updateRoleMenu(Integer roleId, String menuIds) {
        roleMenuService.updateRoleMenu(roleId, menuIds);
        return success();
    }

}
