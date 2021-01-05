package com.xiaot.factory.config.exception;

import com.xiaot.factory.enumeration.ErrorEnum;

/**
 * 增删改异常
 */
public class CrudException extends BaseException {

    public CrudException(ErrorEnum errorEnum) {
        super(errorEnum);
    }

}
