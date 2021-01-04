package com.xiaot.factory.util;

import com.xiaot.factory.enumeration.ErrorEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回前端格式
 */
public class Result {

    /**
     * 初始化返回map
     * @param code 状态码
     * @param msg 返回信息
     * @param data 返回数据
     * @return 返回包含code、msg、data的map
     */
    private static Map<String, Object> init(int code, String msg, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    public static Map<String, Object> success() {
        return init(200, "成功", null);
    }

    public static Map<String, Object> success(String msg) {
        return init(200, msg, null);
    }

    public static Map<String, Object> success(Object data) {
        return init(200, "成功", data);
    }

    public static Map<String, Object> success(String msg, Object data) {
        return init(200, msg, data);
    }

    public static Map<String, Object> fail() {
        return init(500, "开发人员正在努力中！", null);
    }

    public static Map<String, Object> fail(ErrorEnum errorEnum) {
        return init(errorEnum.getCode(), errorEnum.getMsg(), null);
    }

}
