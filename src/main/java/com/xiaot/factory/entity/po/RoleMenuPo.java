package com.xiaot.factory.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
