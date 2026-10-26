package com.BloodBank.bloodbank.service;
import com.BloodBank.bloodbank.entity.Donation;
import com.BloodBank.bloodbank.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DonationService {
    @Autowired
    private DonationRepository repository;

    public List<Donation> getAll() { return repository.findAll(); }
    public Donation add(Donation donation) { return repository.save(donation); }
    public void delete(int id) { repository.deleteById(id); }
}