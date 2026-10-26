package com.BloodBank.bloodbank.controller;

import com.BloodBank.bloodbank.entity.Recipient;
import com.BloodBank.bloodbank.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipient")
@CrossOrigin(origins = "http://localhost:3000")
public class RecipientController {

    @Autowired
    private RecipientService service;

    @GetMapping("/all")
    public List<Recipient> getAll() {
        return service.getAllRecipients();
    }

    @PostMapping("/add")
    public Recipient add(@RequestBody Recipient recipient) {
        return service.addRecipient(recipient);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.deleteRecipient(id);
    }
}