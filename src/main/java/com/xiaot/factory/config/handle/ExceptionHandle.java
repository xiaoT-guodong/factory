package com.xiaot.factory.config.handle;

import com.xiaot.factory.config.exception.CrudException;
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
        if(e instanceof CrudException) {
            CrudException exception = (CrudException) e;
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(fail(exception.getErrorEnum()).toString());
        }
    }

}
