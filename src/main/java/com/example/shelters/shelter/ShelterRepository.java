package com.example.shelters.shelter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShelterRepository extends JpaRepository<Shelter, Integer> {
    Optional<Shelter> findByName(String name);
    boolean existsByName(String name);
}
