package com.xiaot.factory.enumeration;

/**
 * 状态码信息
 */
public enum ErrorEnum {

    REQUEST_METHOD(404, "不支持的请求，请检查后重试！"),

    ERROR(500, "开发人员正在努力中！"),
    ERROR_DATA_SOURCE(501, "操作数据库异常！"),

    LOGIN_ERROR(201, "账号或密码错误，请重新登录！"),
    LOGIN_PAST(202, "未登录或登录已过期，请重新登录！"),

    OPERATOR_ADD(206, "账号添加失败！"),
    OPERATOR_UPDATE(207, "账号修改失败！"),
    OPERATOR_EXIT(208, "账号已存在，请重新输入！"),

    MENU_ADD(211, "菜单添加失败！"),
    MENU_UPDATE(212, "菜单修改失败！"),

    ROLE_ADD(216, "角色添加失败！"),
    ROLE_UPDATE(217, "角色修改失败！"),
    ROLE_DELETE(218, "角色删除失败！"),

    PURCHASE_ADD(221, "进货添加失败！"),
    PURCHASE_UPDATE(222, "进货修改失败！"),
    PURCHASE_INVENTORY_UPDATE(223, "库存修改失败！"),

    INVENTORY_ADD(226, "库存添加失败！"),
    INVENTORY_UPDATE(227, "库存修改失败！"),

    SALES_ADD(231, "出货添加失败！"),
    SALES_UPDATE(232, "出货修改失败！"),
    SALES_INVENTORY_UPDATE(233, "库存修改失败！"),
    SALES_SURPLUS(234, "库存不足！"),
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
