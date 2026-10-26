package com.BloodBank.bloodbank.controller;

import com.BloodBank.bloodbank.entity.BloodRequest;
import com.BloodBank.bloodbank.service.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
@CrossOrigin(origins = "http://localhost:3000")
public class BloodRequestController {

    @Autowired
    private BloodRequestService service;

    @GetMapping("/all")
    public List<BloodRequest> getAll() {
        return service.getAllRequests();
    }

    @PostMapping("/add")
    public BloodRequest add(@RequestBody BloodRequest request) {
        return service.createRequest(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.deleteRequest(id);
    }
}