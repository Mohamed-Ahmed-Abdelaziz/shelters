package com.example.shelters.admin;

import com.example.shelters.shelter.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Shelter, Integer> {
}
