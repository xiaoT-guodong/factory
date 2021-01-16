package com.xiaot.factory.service;

import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.OperatorPo;
import com.xiaot.factory.entity.vo.OperatorVo;

import java.util.List;

public interface OperatorService {

    /**
     * 查找员列表
     * @param loginName
     * @param password
     * @return
     */
    OperatorVo findOperator(String loginName, String password);

    /**
     * 操作员列表
     * @param pageQueryEntity
     * @return
     */
    List<OperatorVo> list(PageQueryEntity pageQueryEntity);

    /**
     * 操作员列表条数
     * @return
     */
    Integer listCount();

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

    /**
     * 删除操作员
     * @param operatorId
     */
    void deleteOperator(Integer operatorId);

}
