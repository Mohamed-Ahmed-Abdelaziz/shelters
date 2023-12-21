package com.example.shelters.adopter;

import com.example.shelters.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdopterRepository extends JpaRepository<Adopter, Integer> {
    Optional<Adopter> findByEmail(String email);
    Boolean existsByEmail(String email);
}
