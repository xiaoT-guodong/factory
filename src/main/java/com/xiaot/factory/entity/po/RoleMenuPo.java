package com.xiaot.factory.entity.po;

import lombok.Data;

@Data
public class RoleMenuPo {

    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 菜单id
     */
    private Integer[] menuId;

}
