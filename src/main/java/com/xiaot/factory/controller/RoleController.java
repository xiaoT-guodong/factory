package com.xiaot.factory.controller;

import com.xiaot.factory.entity.po.RolePo;
import com.xiaot.factory.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
        List<RolePo> data = roleService.roleList();
        return success(data);
    }

    @PostMapping("/add")
    public Map<String, Object> add(RolePo rolePo) {
        roleService.addRole(rolePo);
        return success();
    }

    @PostMapping("/update")
    public Map<String, Object> update(RolePo rolePo) {
        roleService.updateRole(rolePo);
        return success();
    }

}
