package com.xiaot.factory.controller;

import com.xiaot.factory.entity.po.SalesPo;
import com.xiaot.factory.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.xiaot.factory.util.ResultUtil.success;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping
    public Map<String, Object> listSales() {
        return success(salesService.list());
    }

    @PostMapping
    public Map<String, Object> addSales(SalesPo salesPo) {
        salesService.addSales(salesPo);
        return success();
    }

    @PutMapping
    public Map<String, Object> updateSales(SalesPo salesPo) {
        salesService.updateSales(salesPo);
        return success();
    }

}
