package com.xiaot.factory.service.impl;

import com.xiaot.factory.dao.OperatorDao;
import com.xiaot.factory.entity.po.OperatorPo;
import com.xiaot.factory.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorDao operatorDao;

    @Override
    public OperatorPo findOperator(String loginName, String password) {
        return operatorDao.findOperator(loginName, password);
    }

}
