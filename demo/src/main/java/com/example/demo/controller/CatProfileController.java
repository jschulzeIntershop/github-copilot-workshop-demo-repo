package com.example.demo.controller;

import com.example.demo.entity.CatProfile;
import com.example.demo.service.CatProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat-profiles")
public class CatProfileController {

    private final CatProfileService service;

    public CatProfileController(CatProfileService service) {
        this.service = service;
    }

    @PostMapping
    public CatProfile saveCatProfile(@RequestBody CatProfile catProfile) {
        return service.saveCatProfile(catProfile);
    }

    @GetMapping
    public List<CatProfile> getAllCatProfiles() {
        return service.getAllCatProfiles();
    }
}