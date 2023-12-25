package com.example.shelters.pet;

import com.example.shelters.admin.AdminRepository;
import com.example.shelters.shelter.Shelter;
import com.example.shelters.shelter.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final ShelterRepository shelterRepository;
    @Autowired
    public PetService(PetRepository petRepository, ShelterRepository shelterRepository) {
        this.petRepository = petRepository;
        this.shelterRepository = shelterRepository;
    }

    public List<Pet> getPets() {
        return petRepository.findAll();
    }

    @Transactional
    public boolean addPet(int shelterId, Pet pet) {
        Shelter shelter = this.shelterRepository.findById(shelterId).get();
        List<Pet> pets = shelter.getPets();
        Pet newPet = new Pet(
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getAge(),
                pet.getGender(),
                pet.getHealthStatus(),
                pet.getBehaviour(),
                new Shelter(shelterId)
                );
        pets.add(newPet);
        shelter.setPets(pets);
//        this.shelterRepository.save(shelter);
        return true;
    }
}
