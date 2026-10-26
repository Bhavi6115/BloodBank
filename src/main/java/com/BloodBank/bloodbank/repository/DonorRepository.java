package com.BloodBank.bloodbank.repository;

import com.BloodBank.bloodbank.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
    List<Donor> findByBloodGroup(String bloodGroup);
}