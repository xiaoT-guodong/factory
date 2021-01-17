package com.xiaot.factory.controller;

import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.OperatorPo;
import com.xiaot.factory.service.OperatorService;
import com.xiaot.factory.util.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.xiaot.factory.util.ResultUtil.page;
import static com.xiaot.factory.util.ResultUtil.success;

/**
 * 登录相关接口
 */
@RestController
@RequestMapping("/")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @PostMapping("/login")
    public Map<String, Object> login(String loginName, String password, HttpServletRequest request) {
        ShiroUtil.login(loginName, password);
        return success(ShiroUtil.loginUser());
    }

    @GetMapping("/operator")
    public Map<String, Object> list(PageQueryEntity pageQueryEntity) {
        return page(operatorService.listCount(), operatorService.list(pageQueryEntity));
    }

    @PostMapping("/operator")
    public Map<String, Object> add(OperatorPo operatorPo) {
        operatorService.addOperator(operatorPo);
        return success("添加成功");
    }

    @PutMapping("/operator")
    public Map<String, Object> update(OperatorPo operatorPo) {
        operatorService.updateOperator(operatorPo);
        return success("修改成功");
    }

    @DeleteMapping("/operator")
    public Map<String, Object> delete(Integer operatorId) {
        operatorService.deleteOperator(operatorId);
        return success("删除成功");
    }

    @GetMapping("/logout")
    public Map<String, Object> logout(HttpServletRequest request) {
        ShiroUtil.logout();
        return success("注销成功。");
    }

}
