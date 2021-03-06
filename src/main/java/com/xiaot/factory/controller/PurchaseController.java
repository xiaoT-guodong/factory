package com.xiaot.factory.controller;

import com.xiaot.factory.entity.PageQueryEntity;
import com.xiaot.factory.entity.po.PurchasePo;
import com.xiaot.factory.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.xiaot.factory.util.ResultUtil.page;
import static com.xiaot.factory.util.ResultUtil.success;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public Map<String, Object> listPurchase(PageQueryEntity pageQueryEntity) {
        return page(purchaseService.listCount(), purchaseService.list(pageQueryEntity));
    }

    @PostMapping
    public Map<String, Object> addPurchase(PurchasePo purchasePo) {
        purchaseService.addPurchase(purchasePo);
        return success();
    }

    @PutMapping
    public Map<String, Object> updatePurchase(PurchasePo purchasePo) {
        purchaseService.updatePurchase(purchasePo);
        return success();
    }

}
