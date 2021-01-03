package com.xiaot.factory.service;

import com.xiaot.factory.entity.po.OperatorPo;

public interface OperatorService {

    /**
     * 查找员列表
     * @param loginName
     * @param password
     * @return
     */
    OperatorPo findOperator(String loginName, String password);

    /**
     * 添加操作员
     * @param operatorPo
     */
    void addOperator(OperatorPo operatorPo);

    /**
     * 修改操作员
     * @param operatorPo
     */
    void updateOperator(OperatorPo operatorPo);

}
