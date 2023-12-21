package com.example.shelters.staff;

import com.example.shelters.admin.Admin;
import com.example.shelters.admin.AdminRepository;
import com.example.shelters.shelter.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    private final StaffRepository staffRepository;
    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public int logIn(Staff staff) {
        if(this.staffRepository.existsByEmail(staff.getEmail())) {
            if(this.staffRepository.findByEmail(staff.getEmail())
                    .get().getPassword().equals(staff.getPassword())){
                return this.staffRepository.findByEmail(staff.getEmail()).get().getStaffId();
            }
        }
        return -1;
    }

    public int signUp(Staff staff, int shelterId) {
        if(this.staffRepository.existsByEmail(staff.getEmail())){
            return -1;
        }
        Staff staff1 = new Staff(
                staff.getEmail(),
                staff.getPassword(),
                staff.getName(),
                staff.getRole(),
                staff.getContact(),
                new Shelter(shelterId)
        );
        this.staffRepository.save(staff);
        return this.staffRepository.findByEmail(staff.getEmail()).get().getStaffId();
    }
}
