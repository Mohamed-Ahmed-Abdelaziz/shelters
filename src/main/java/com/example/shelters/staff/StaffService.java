package com.example.shelters.staff;

import com.example.shelters.admin.Admin;
import com.example.shelters.admin.AdminRepository;
import com.example.shelters.application.Application;
import com.example.shelters.shelter.Shelter;
import com.example.shelters.shelter.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;
    private final ShelterRepository shelterRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository, ShelterRepository shelterRepository) {
        this.staffRepository = staffRepository;
        this.shelterRepository = shelterRepository;
    }

    public int logIn(Staff staff) {
        if (this.staffRepository.existsByEmail(staff.getEmail())) {
            if (this.staffRepository.findByEmail(staff.getEmail())
                    .get().getPassword().equals(staff.getPassword())) {
                return this.staffRepository.findByEmail(staff.getEmail()).get().getStaffId();
            } else {
                throw new IllegalStateException("Password is incorrect");
            }
        } else {
            throw new IllegalStateException("Email does not exist");
        }
    }

    public int signUp(Staff staff, int shelterId) {
        if (this.staffRepository.existsByEmail(staff.getEmail())) {
           throw new IllegalStateException("Email already exists");
        }
        Staff staff1 = new Staff(
                staff.getEmail(),
                staff.getPassword(),
                staff.getName(),
                staff.getRole(),
                staff.getContact(),
                shelterRepository.findById(shelterId).get()
        );
        this.staffRepository.save(staff1);
        return this.staffRepository.findByEmail(staff.getEmail()).get().getStaffId();
    }

    public List<Staff> getStaffs() {
        return staffRepository.findAll();
    }

    public List<Application> getStaffApplications(int staffId) {
        int shelterId = staffRepository.findById(staffId).get().getShelterId();
        return shelterRepository.findById(shelterId).get().getApplications();
    }
}
