package com.xiaot.factory.config.interceptor;

import com.xiaot.factory.enumeration.ErrorEnum;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.xiaot.factory.util.Result.fail;

/**
 * 登录拦截：未登录返回错误信息
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(fail(ErrorEnum.LOGIN_PAST).toString());
            return false;
        }
        return true;
    }
}
