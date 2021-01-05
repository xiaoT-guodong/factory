package com.xiaot.factory.service.impl;

import com.xiaot.factory.config.exception.CrudException;
import com.xiaot.factory.dao.PurchaseDao;
import com.xiaot.factory.entity.po.PurchasePo;
import com.xiaot.factory.enumeration.ErrorEnum;
import com.xiaot.factory.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDao purchaseDao;

    @Override
    public List<PurchasePo> list() {
        return purchaseDao.listPurchase();
    }

    @Override
    public void addPurchase(PurchasePo purchasePo) {
        if(purchaseDao.addPurchase(purchasePo) < 1) {
            throw new CrudException(ErrorEnum.PURCHASE_ADD);
        }
    }

    @Override
    public void updatePurchase(PurchasePo purchasePo) {
        if(purchaseDao.updatePurchase(purchasePo) < 1) {
            throw new CrudException(ErrorEnum.PURCHASE_UPDATE);
        }
    }

}
