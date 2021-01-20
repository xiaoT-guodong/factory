package com.xiaot.factory.service.impl;

import com.xiaot.factory.config.exception.CrudException;
import com.xiaot.factory.dao.OperatorDao;
import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.OperatorPo;
import com.xiaot.factory.entity.vo.OperatorVo;
import com.xiaot.factory.enumeration.ErrorEnum;
import com.xiaot.factory.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorDao operatorDao;

    @Override
    public OperatorVo findOperator(String loginName, String password) {
        OperatorVo operator = operatorDao.findOperator(loginName, password);
        return operator;
    }

    @Override
    public List<OperatorVo> list(PageQueryEntity pageQueryEntity) {
        return operatorDao.listOperator(pageQueryEntity);
    }

    @Override
    public Integer listCount() {
        return operatorDao.listCount();
    }

    @Override
    public void addOperator(OperatorPo operatorPo) {
        if (operatorDao.loginNameExist(operatorPo.getId(), operatorPo.getLoginName()) > 0) {
            throw new CrudException(ErrorEnum.OPERATOR_EXIT);
        }
        if(operatorDao.addOperator(operatorPo) < 1) {
            throw new CrudException(ErrorEnum.OPERATOR_ADD);
        }
    }

    @Override
    public void updateOperator(OperatorPo operatorPo) {
        if (operatorDao.loginNameExist(operatorPo.getId(), operatorPo.getLoginName()) > 0) {
            throw new CrudException(ErrorEnum.OPERATOR_EXIT);
        }
        if(operatorDao.updateOperator(operatorPo) < 1) {
            throw new CrudException(ErrorEnum.OPERATOR_UPDATE);
        }
    }

    @Override
    public void deleteOperator(Integer operatorId) {
        if(operatorDao.updateOperator(new OperatorPo().setId(operatorId).setDelete(1)) < 1) {
            throw new CrudException(ErrorEnum.OPERATOR_UPDATE);
        }
    }
}
