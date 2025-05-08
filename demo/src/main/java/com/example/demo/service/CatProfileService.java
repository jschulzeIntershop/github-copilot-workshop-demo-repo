package com.example.demo.service;

import com.example.demo.entity.CatProfile;
import com.example.demo.repository.CatProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatProfileService {

    private final CatProfileRepository repository;

    public CatProfileService(CatProfileRepository repository) {
        this.repository = repository;
    }

    public CatProfile saveCatProfile(CatProfile catProfile) {
        return repository.save(catProfile);
    }

    public List<CatProfile> getAllCatProfiles() {
        return repository.findAll();
    }
}