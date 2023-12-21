package com.example.shelters.admin;

import com.example.shelters.shelter.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByEmail(String email);
    Boolean existsByEmail(String email);
}
