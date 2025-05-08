package com.example.demo.repository;

import com.example.demo.entity.CatProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatProfileRepository extends JpaRepository<CatProfile, Long> {
}