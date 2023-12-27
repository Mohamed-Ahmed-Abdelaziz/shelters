package com.example.shelters.pet;

import com.example.shelters.admin.AdminRepository;
import com.example.shelters.shelter.Shelter;
import com.example.shelters.shelter.ShelterRepository;
import com.example.shelters.staff.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final ShelterRepository shelterRepository;
    private final StaffRepository staffRepository;
    @Autowired
    public PetService(PetRepository petRepository, ShelterRepository shelterRepository, StaffRepository staffRepository) {
        this.petRepository = petRepository;
        this.shelterRepository = shelterRepository;
        this.staffRepository = staffRepository;
    }

    public List<Pet> getPets() {
        return petRepository.findAll();
    }

    @Transactional
    public boolean addPet(int staffId, Pet pet) {
        int shelterId = staffRepository.findById(staffId).get().getShelterId();
        Shelter shelter = shelterRepository.findById(shelterId).get();
        List<Pet> pets = shelter.getPets();
        Pet newPet = new Pet(
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getAge(),
                pet.getGender(),
                pet.getHealthStatus(),
                pet.getBehaviour(),
                shelter
                );
        pets.add(newPet);
        shelter.setPets(pets);
//        this.shelterRepository.save(shelter);
        return true;
    }
}
