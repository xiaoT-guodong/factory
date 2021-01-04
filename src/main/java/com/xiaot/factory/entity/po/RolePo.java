package com.xiaot.factory.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePo {

    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;

}
