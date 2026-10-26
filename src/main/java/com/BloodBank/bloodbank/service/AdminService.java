package com.BloodBank.bloodbank.service;

import com.BloodBank.bloodbank.entity.Admin;
import com.BloodBank.bloodbank.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public Admin addAdmin(Admin admin) {
        return repository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return repository.findAll();
    }

    public Optional<Admin> getAdminById(int id) {
        return repository.findById(id);
    }

    public Admin updateAdmin(Admin admin) {
        return repository.save(admin);
    }

    public void deleteAdmin(int id) {
        repository.deleteById(id);
    }

    // UPDATED LOGIN METHOD to handle potential duplicates safely
    public Optional<Admin> login(String username, String password) {
        // We now fetch a List instead of a single Optional
        List<Admin> admins = repository.findByUsernameAndPassword(username, password);

        // If the list is empty, the credentials were wrong
        if (admins.isEmpty()) {
            return Optional.empty();
        }

        // If we found a match, return the first one.
        // (Even if there are duplicates, it won't crash the app anymore)
        return Optional.of(admins.get(0));
    }
}