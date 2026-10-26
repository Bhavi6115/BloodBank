package com.BloodBank.bloodbank.service;

import com.BloodBank.bloodbank.entity.BloodRequest;
import com.BloodBank.bloodbank.repository.BloodRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BloodRequestService {

    @Autowired
    private BloodRequestRepository repository;

    public List<BloodRequest> getAllRequests() {
        return repository.findAll();
    }

    public BloodRequest createRequest(BloodRequest request) {
        request.setStatus("PENDING");
        request.setRequestDate(LocalDate.now());
        return repository.save(request);
    }

    public void deleteRequest(int id) {
        repository.deleteById(id);
    }
}