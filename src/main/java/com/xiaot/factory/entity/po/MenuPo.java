package com.xiaot.factory.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuPo {

    private Integer id;
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
    private String menu_image;

}
