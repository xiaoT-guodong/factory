package com.xiaot.factory.entity.vo;

import lombok.Data;

import java.util.List;

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
     * 拥有的角色
     */
    List<String> roles;

}
