package com.xiaot.factory.enumeration;

/**
 * 状态码信息
 */
public enum ErrorEnum {

    LOGIN_ERROR(201, "账号或密码错误，请重新登录！"),
    LOGIN_PAST(202, "未登录或登录已过期，请重新登录！"),
    OPERATOR_ADD(203, "账号添加失败！"),
    OPERATOR_UPDATE(204, "账号修改失败！"),
    MENU_ADD(205, "菜单添加失败！"),
    MENU_UPDATE(206, "菜单修改失败！"),
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
