package com.xiaot.factory.config.handle;

import com.xiaot.factory.config.exception.BaseException;
import com.xiaot.factory.enumeration.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.xiaot.factory.util.ResultUtil.fail;

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
        if(e instanceof PersistenceException) {
            response.getWriter().write(fail(ErrorEnum.ERROR_DATA_SOURCE).toString());
            return;
        }
        e.printStackTrace();
        response.getWriter().write(fail().toString());
    }

}
