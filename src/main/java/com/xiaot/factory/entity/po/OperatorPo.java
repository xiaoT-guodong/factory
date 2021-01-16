package com.xiaot.factory.entity.po;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
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

    /**
     * 是否删除
     */
    private Integer delete;

}
