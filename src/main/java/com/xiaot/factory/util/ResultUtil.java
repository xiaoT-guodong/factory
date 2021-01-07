package com.xiaot.factory.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaot.factory.enumeration.ErrorEnum;
import lombok.SneakyThrows;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回前端格式
 */
public class ResultUtil {

    /**
     * 初始化返回map
     * @param code 状态码
     * @param msg 返回信息
     * @param data 返回数据
     * @return 返回包含code、msg、data的map
     */
    private static Map<String, Object> init(int code, String msg, Object data) {
        Map<String, Object> map = new MyHashMap();
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

    public static Map<String, Object> page(Integer count, List<?> data) {
        Map<String, Object> map = new HashMap<>();
        map.put("count", count == null ? 0 : count);
        map.put("list", data == null ? Collections.emptyList() : data);
        return success(map);
    }

    public static Map<String, Object> fail() {
        return init(ErrorEnum.ERROR.getCode(), ErrorEnum.ERROR.getMsg(), null);
    }

    public static Map<String, Object> fail(ErrorEnum errorEnum) {
        return init(errorEnum.getCode(), errorEnum.getMsg(), null);
    }

    static class MyHashMap extends HashMap<String, Object> {

        @SneakyThrows
        @Override
        public String toString() {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        }

    }

}
