package com.example.shelters.staff;

import com.example.shelters.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Optional<Staff> findByEmail(String email);
    Boolean existsByEmail(String email);
}
