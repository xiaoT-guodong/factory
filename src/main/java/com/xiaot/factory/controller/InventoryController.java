package com.xiaot.factory.controller;

import com.xiaot.factory.entity.po.InventoryPo;
import com.xiaot.factory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.xiaot.factory.util.Result.success;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public Map<String, Object> listInventory() {
        return success(inventoryService.list());
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

}
