package com.BloodBank.bloodbank.service;

import com.BloodBank.bloodbank.entity.Inventory;
import com.BloodBank.bloodbank.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public List<Inventory> getAll() {
        return repository.findAll();
    }

    public Inventory add(Inventory inventory) {
        return repository.save(inventory);
    }

    public Inventory update(Inventory inventory) {
        return repository.save(inventory);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}