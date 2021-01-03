package com.xiaot.factory.config.exception;

import com.xiaot.factory.enumeration.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CrudException extends RuntimeException {

    private ErrorEnum errorEnum;

}
