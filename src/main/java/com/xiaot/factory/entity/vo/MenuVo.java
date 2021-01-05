package com.xiaot.factory.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class MenuVo {

    private Integer id;
    /**
     * 父级菜单id
     */
    private Integer pId;
    /**
     * 菜单名
     */
    private String menuName;
    /**
     * 菜单url
     */
    private String menuUrl;
    /**
     * 菜单图片url
     */
    private String menuImage;
    /**
     * 子菜单
     */
    private List<MenuVo> children;
    /**
     * 是否已拥有该菜单权限
     */
    private Boolean checked = false;

}
