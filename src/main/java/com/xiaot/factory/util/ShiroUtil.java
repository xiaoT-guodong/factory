package com.xiaot.factory.util;

import com.xiaot.factory.entity.vo.OperatorVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {

    private static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取当前登录用户
     * @return
     */
    public static OperatorVo loginUser() {
        return (OperatorVo) getSubject().getPrincipal();
    }

    /**
     * 登录
     * @param username
     * @param password
     */
    public static void login(String username, String password) {
        getSubject().login(new UsernamePasswordToken(username, password));
    }

    /**
     * 注销
     */
    public static void logout() {
        getSubject().logout();
    }

}
