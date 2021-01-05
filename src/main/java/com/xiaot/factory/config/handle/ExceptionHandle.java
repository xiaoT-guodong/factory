package com.xiaot.factory.config.handle;

import com.xiaot.factory.config.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.xiaot.factory.util.Result.fail;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler
    public void handleException(Exception e, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if(e instanceof BaseException) {
            BaseException exception = (BaseException) e;
            response.getWriter().write(fail(exception.getErrorEnum()).toString());
            return;
        }
        e.printStackTrace();
        response.getWriter().write(fail().toString());
    }

}
