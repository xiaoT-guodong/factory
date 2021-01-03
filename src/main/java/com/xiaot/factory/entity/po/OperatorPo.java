package com.xiaot.factory.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperatorPo {

    private Integer id;
    /**
     * 登录账号
     */
    private String loginName;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 用户名
     */
    private String username;
    /**
     * 角色id
     */
    private Integer roleId;

}
