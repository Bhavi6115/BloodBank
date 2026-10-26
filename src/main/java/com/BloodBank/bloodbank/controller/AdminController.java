package com.BloodBank.bloodbank.controller;

import com.BloodBank.bloodbank.entity.Admin;
import com.BloodBank.bloodbank.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/add")
    public Admin addAdmin(@RequestBody Admin admin) {
        return service.addAdmin(admin);
    }

    @PostMapping("/login")
    public Admin login(@RequestBody Admin admin) {
        return service.login(admin.getUsername(), admin.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid Username or Password"));
    }

    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        return service.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable int id) {
        return service.getAdminById(id);
    }

    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return service.updateAdmin(admin);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable int id) {
        service.deleteAdmin(id);
        return "Admin Deleted Successfully";
    }
}