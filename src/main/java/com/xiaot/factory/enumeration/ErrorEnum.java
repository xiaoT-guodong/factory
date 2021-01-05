package com.xiaot.factory.enumeration;

/**
 * 状态码信息
 */
public enum ErrorEnum {

    ERROR(500, "开发人员正在努力中！"),

    LOGIN_ERROR(201, "账号或密码错误，请重新登录！"),
    LOGIN_PAST(202, "未登录或登录已过期，请重新登录！"),

    OPERATOR_ADD(211, "账号添加失败！"),
    OPERATOR_UPDATE(212, "账号修改失败！"),
    OPERATOR_EXIT(213, "账号已存在，请重新输入！"),

    MENU_ADD(221, "菜单添加失败！"),
    MENU_UPDATE(222, "菜单修改失败！"),

    ROLE_ADD(231, "角色添加失败！"),
    ROLE_UPDATE(232, "角色修改失败！"),
    ;

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态码信息
     */
    private String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
