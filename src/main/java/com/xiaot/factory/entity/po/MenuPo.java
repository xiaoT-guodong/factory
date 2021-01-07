package com.xiaot.factory.entity.po;

import lombok.Data;

@Data
public class MenuPo {

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

}
