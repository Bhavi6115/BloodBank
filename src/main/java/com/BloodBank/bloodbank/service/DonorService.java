package com.BloodBank.bloodbank.service;

import com.BloodBank.bloodbank.entity.Donor;
import com.BloodBank.bloodbank.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {

    @Autowired
    private DonorRepository repository;

    // 1. Used in @PostMapping("/add")
    public Donor addDonor(Donor donor) {
        return repository.save(donor);
    }

    // 2. Used in @GetMapping("/all")
    public List<Donor> getAllDonors() {
        return repository.findAll();
    }

    // 3. Used in @GetMapping("/{id}")
    public Optional<Donor> getDonorById(int id) {
        return repository.findById(id);
    }

    // Additional methods for later (Update, Delete, Search)
    public Donor updateDonor(Donor donor) {
        return repository.save(donor);
    }

    public void deleteDonor(int id) {
        repository.deleteById(id);
    }

    public List<Donor> getDonorByBloodGroup(String bloodGroup) {
        return repository.findByBloodGroup(bloodGroup);
    }
}