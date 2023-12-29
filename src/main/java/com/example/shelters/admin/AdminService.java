package com.example.shelters.admin;

import com.example.shelters.shelter.Shelter;
import com.example.shelters.shelter.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final ShelterRepository shelterRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository, ShelterRepository shelterRepository) {
        this.adminRepository = adminRepository;
        this.shelterRepository = shelterRepository;
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

    @Transactional
    public int addShelter(int adminId, Shelter shelter) {
        if(! adminRepository.existsById(adminId)) return -1;
        if(shelterRepository.existsByName(shelter.getName())) return -1;
        Admin admin = adminRepository.findById(adminId).get();
        Shelter shelter1 = new Shelter(
                shelter.getName(),
                shelter.getLocation(),
                shelter.getContact(),
                admin);
        shelterRepository.save(shelter1);
        admin.setShelter(shelterRepository.findByName(shelter.getName()).get());
        return shelterRepository.findByName(shelter.getName()).get().getShelterId();
    }

    @Transactional
    public boolean updateShelter(int adminId, Shelter newShelter) {
        if(! adminRepository.existsById(adminId)) return false;
        Shelter oldShelter = shelterRepository.findById(adminRepository.findById(adminId).get().getShelterId()).get();
        if(!oldShelter.getName().equals(newShelter.getName())) {
            if (shelterRepository.existsByName(newShelter.getName())) return false;
        }
        oldShelter.setName(newShelter.getName());
        oldShelter.setLocation(newShelter.getLocation());
        oldShelter.setContact(newShelter.getContact());
        return true;
    }
}
