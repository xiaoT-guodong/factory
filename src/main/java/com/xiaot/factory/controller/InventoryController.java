package com.xiaot.factory.controller;

import com.xiaot.factory.entity.QueryEntity;
import com.xiaot.factory.entity.po.InventoryPo;
import com.xiaot.factory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.xiaot.factory.util.ResultUtil.page;
import static com.xiaot.factory.util.ResultUtil.success;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public Map<String, Object> listInventory(QueryEntity query) {
        return page(inventoryService.listCount(), inventoryService.list(query));
    }

    @PostMapping
    public Map<String, Object> addInventory(InventoryPo inventoryPo) {
        inventoryService.addInventory(inventoryPo);
        return success();
    }

    @PutMapping
    public Map<String, Object> updateInventory(InventoryPo inventoryPo) {
        inventoryService.updateInventory(inventoryPo);
        return success();
    }

    @GetMapping("/select")
    public Map<String, Object> allInventory() {
        return success(inventoryService.listSelect());
    }

}
