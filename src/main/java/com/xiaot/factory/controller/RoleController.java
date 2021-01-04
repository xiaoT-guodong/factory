package com.xiaot.factory.controller;

import com.xiaot.factory.entity.po.RolePo;
import com.xiaot.factory.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.xiaot.factory.util.Result.success;

/**
 * 角色相关接口
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public Map<String, Object> roleList() {
        return success(roleService.roleList());
    }

    @GetMapping("/add")
    public Map<String, Object> add(RolePo rolePo) {
        roleService.addRole(rolePo);
        return success();
    }

    @GetMapping("/update")
    public Map<String, Object> update(RolePo rolePo) {
        roleService.updateRole(rolePo);
        return success();
    }

}
