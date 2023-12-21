package com.example.shelters.adopter;

import com.example.shelters.admin.Admin;
import com.example.shelters.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdopterService {
    private final AdopterRepository adopterRepository;
    @Autowired
    public AdopterService(AdopterRepository adopterRepository) {
        this.adopterRepository = adopterRepository;
    }

    public int logIn(Adopter adopter) {
        if(this.adopterRepository.existsByEmail(adopter.getEmail())) {
            if(this.adopterRepository.findByEmail(adopter.getEmail())
                    .get().getPassword().equals(adopter.getPassword())){
                return this.adopterRepository.findByEmail(adopter.getEmail()).get().getAdopterId();
            }
        }
        return -1;
    }

    public int signUp(Adopter adopter) {
        if(this.adopterRepository.existsByEmail(adopter.getEmail())){
            return -1;
        }
        this.adopterRepository.save(adopter);
        return this.adopterRepository.findByEmail(adopter.getEmail()).get().getAdopterId();
    }
}
