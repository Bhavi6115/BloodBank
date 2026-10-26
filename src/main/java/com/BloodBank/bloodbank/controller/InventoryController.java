package com.BloodBank.bloodbank.controller;

import com.BloodBank.bloodbank.entity.Inventory;
import com.BloodBank.bloodbank.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping("/all")
    public List<Inventory> getAll() {
        return service.getAll();
    }

    @PostMapping("/add")
    public Inventory add(@RequestBody Inventory inventory) {
        return service.add(inventory);
    }

    @PutMapping("/update")
    public Inventory update(@RequestBody Inventory inventory) {
        return service.update(inventory);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}