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
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String username;

    /**
     * 是否删除
     */
    private Integer delete;

    /**
     * 拥有的角色
     */
    String roles;

}
