package com.BloodBank.bloodbank.controller;
import com.BloodBank.bloodbank.entity.Donation;
import com.BloodBank.bloodbank.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/donation")
@CrossOrigin(origins = "http://localhost:3000")
public class DonationController {
    @Autowired
    private DonationService service;

    @GetMapping("/all")
    public List<Donation> getAll() { return service.getAll(); }

    @PostMapping("/add")
    public Donation add(@RequestBody Donation donation) { return service.add(donation); }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) { service.delete(id); }
}