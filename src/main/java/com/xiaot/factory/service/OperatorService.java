package com.xiaot.factory.service;

import com.xiaot.factory.entity.po.OperatorPo;

public interface OperatorService {

    OperatorPo findOperator(String loginName, String password);

}
