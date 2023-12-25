package com.example.shelters.application;

import com.example.shelters.admin.AdminRepository;
import com.example.shelters.adopter.Adopter;
import com.example.shelters.pet.Pet;
import com.example.shelters.pet.PetRepository;
import com.example.shelters.shelter.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final PetRepository petRepository;
    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository, PetRepository petRepository) {
        this.applicationRepository = applicationRepository;
        this.petRepository = petRepository;
    }

    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }

    public boolean applyApplication(int adopterId, int petId, Application application) {
        int shelterId = petRepository.findById(petId).get().getShelterId();
        Application newApplication = new Application(
                "pending",
                new Pet(petId),
                new Shelter(shelterId),
                new Adopter(adopterId));
        applicationRepository.save(newApplication);
        return true;
    }

    @Transactional
    public boolean acceptApplication(int applicationId) {
        Application application = applicationRepository.findById(applicationId).get();
        application.setStatus("accepted");
        return true;
    }

    @Transactional
    public boolean rejectApplication(int applicationId) {
        Application application = applicationRepository.findById(applicationId).get();
        application.setStatus("rejected");
        return true;
    }

}
