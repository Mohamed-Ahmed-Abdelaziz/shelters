package com.example.shelters.shelter;

import com.example.shelters.admin.AdminRepository;
import com.example.shelters.application.Application;
import com.example.shelters.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterService {
    private final ShelterRepository shelterRepository;
    @Autowired
    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    public List<Shelter> getShelters() {
        return shelterRepository.findAll();
    }

    public List<Pet> getShelterPets(int shelterId) {
        return shelterRepository.findById(shelterId).get().getPets();
    }

    public List<Application> getShelterApplications(int shelterId) {
        return shelterRepository.findById(shelterId).get().getApplications();
    }
}
