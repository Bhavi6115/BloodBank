package com.BloodBank.bloodbank.controller;

import com.BloodBank.bloodbank.entity.Donor;
import com.BloodBank.bloodbank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donor")
@CrossOrigin(origins = "http://localhost:5173")
public class DonorController {

    @Autowired
    private DonorService service;

    @PostMapping("/add")
    public Donor addDonor(@RequestBody Donor donor) {
        return service.addDonor(donor);
    }

    @GetMapping("/all")
    public List<Donor> getAllDonors() {
        return service.getAllDonors();
    }

    @GetMapping("/{id}")
    public Optional<Donor> getDonor(@PathVariable int id) {
        return service.getDonorById(id);
    }

    @PutMapping("/update")
    public Donor updateDonor(@RequestBody Donor donor) {
        return service.updateDonor(donor);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDonor(@PathVariable int id) {
        service.deleteDonor(id);
        return "Donor Deleted Successfully";
    }

    @GetMapping("/bloodgroup/{bloodGroup}")
    public List<Donor> getDonorByBloodGroup(@PathVariable String bloodGroup) {
        return service.getDonorByBloodGroup(bloodGroup);
    }

}