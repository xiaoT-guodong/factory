package com.xiaot.factory.controller;

import com.xiaot.factory.entity.po.OperatorPo;
import com.xiaot.factory.enumeration.ErrorEnum;
import com.xiaot.factory.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.xiaot.factory.util.Result.fail;
import static com.xiaot.factory.util.Result.success;

/**
 * 登录相关接口
 */
@RestController
@RequestMapping("/")
@ConfigurationProperties("request")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @PostMapping("/login")
    public Map<String, Object> login(String loginName, String password, HttpServletRequest request) {
        OperatorPo operator = operatorService.findOperator(loginName, password);
        if(operator != null) {
            request.getSession().setAttribute("username", operator);
            return success(operator);
        }
        return fail(ErrorEnum.LOGIN_ERROR);
    }

}
