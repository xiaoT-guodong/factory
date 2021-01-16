package com.xiaot.factory.entity.vo;

import lombok.Data;

@Data
public class OperatorVo {

    private Integer id;
    
    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 是否删除
     */
    private String delete;

    /**
     * 拥有的角色
     */
    String roles;

    public void setDelete(Boolean delete) {
        this.delete = delete ? "已删除" : "正常";
    }
}
