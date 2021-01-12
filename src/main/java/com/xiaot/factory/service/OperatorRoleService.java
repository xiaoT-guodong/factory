package com.xiaot.factory.service;

import java.util.List;

public interface OperatorRoleService {

    /**
     * 查找操作员拥有的角色
     * @param operatorId
     * @return
     */
    List<String> findHasRoles(Integer operatorId);

    /**
     * 修改操作员角色关联
     * @param operatorId
     * @param roleIds
     */
    void updateOperatorRole(Integer operatorId, String roleIds);

}
