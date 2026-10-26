package com.BloodBank.bloodbank.service;

import com.BloodBank.bloodbank.entity.Recipient;
import com.BloodBank.bloodbank.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipientService {

    @Autowired
    private RecipientRepository repository;

    public List<Recipient> getAllRecipients() {
        return repository.findAll();
    }

    public Recipient addRecipient(Recipient recipient) {
        return repository.save(recipient);
    }

    public void deleteRecipient(int id) {
        repository.deleteById(id);
    }
}