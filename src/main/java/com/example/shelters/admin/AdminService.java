package com.example.shelters.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public int logIn(Admin admin) {
        if(this.adminRepository.existsByEmail(admin.getEmail())) {
            if(this.adminRepository.findByEmail(admin.getEmail())
                    .get().getPassword().equals(admin.getPassword())){
                return this.adminRepository.findByEmail(admin.getEmail()).get().getAdminId();
            }
        }
        return -1;
    }
}
