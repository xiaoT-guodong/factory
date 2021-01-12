package com.xiaot.factory.controller;

import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.OperatorPo;
import com.xiaot.factory.enumeration.ErrorEnum;
import com.xiaot.factory.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.xiaot.factory.util.ResultUtil.*;

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
        OperatorPo operator = operatorService.findOperator(loginName, password);
        if(operator != null) {
            request.getSession().setAttribute("loginUser", operator);
            return success(operator);
        }
        return fail(ErrorEnum.LOGIN_ERROR);
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

    @GetMapping("/logout")
    public Map<String, Object> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginUser");
        return success("注销成功。");
    }

}
