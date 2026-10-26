package com.BloodBank.bloodbank.repository;

import com.BloodBank.bloodbank.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    // MUST BE A LIST (Not Optional) to match the AdminService
    List<Admin> findByUsernameAndPassword(String username, String password);

}