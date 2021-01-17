package com.xiaot.factory.dao;

import com.xiaot.factory.entity.po.RolePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleDao {

    /**
     * 角色列表
     * @return
     */
    List<RolePo> roleList();

    /**
     * 添加角色
     * @param rolePo
     * @return
     */
    int addRole(RolePo rolePo);

    /**
     * 修改角色
     * @param rolePo
     * @return
     */
    int updateRole(RolePo rolePo);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    int deleteRole(@Param("roleId") Integer roleId);

}
