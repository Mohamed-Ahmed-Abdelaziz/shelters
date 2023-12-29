package com.example.shelters.application;

import com.example.shelters.adopter.Adopter;
import com.example.shelters.adopter.AdopterRepository;
import com.example.shelters.notification.Notification;
import com.example.shelters.pet.Pet;
import com.example.shelters.pet.PetRepository;
import com.example.shelters.shelter.Shelter;
import com.example.shelters.staff.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final PetRepository petRepository;
    private final StaffRepository staffRepository;
    private final AdopterRepository adopterRepository;
    @Autowired
    public ApplicationService(
            ApplicationRepository applicationRepository,
            PetRepository petRepository,
            StaffRepository staffRepository,
            AdopterRepository adopterRepository) {
        this.applicationRepository = applicationRepository;
        this.petRepository = petRepository;
        this.staffRepository = staffRepository;
        this.adopterRepository = adopterRepository;
    }

    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }

    public boolean applyApplication(int adopterId, int petId, Application application) {
        int shelterId = petRepository.findById(petId).get().getShelterId();
        Application newApplication = new Application(
                "pending",
                application.getPetCareExperience(),
                application.getPetPreferences(),
                application.getFinancialInfo(),
                application.getLifeStyle(),
                new Pet(petId),
                new Shelter(shelterId),
                new Adopter(adopterId));
        applicationRepository.save(newApplication);
        return true;
    }

    @Transactional
    public boolean acceptApplication(int applicationId, int staffId) {
        if(!staffRepository.existsById(staffId)) return false;
        if(staffRepository.findById(staffId).get().getShelterId() != applicationRepository.findById(applicationId).get().getShelterId())
            return false;
        Application application = applicationRepository.findById(applicationId).get();
        application.setStatus("accepted");

        String body = "Congratulations! your request for adopting "
                + applicationRepository.findById(applicationId).get().getPetName()
                + " has been accepted";
        Notification notification= new Notification(body, "unread");
        int adopterId = applicationRepository.findById(applicationId).get().getAdopterId();
        Adopter adopter = adopterRepository.findById(adopterId).get();
        List<Notification> notifications = adopter.getNotifications();
        notifications.add(notification);
        adopter.setNotifications(notifications);
        return true;
    }

    @Transactional
    public boolean rejectApplication(int applicationId, int staffId) {
        if(!staffRepository.existsById(staffId)) return false;
        if(staffRepository.findById(staffId).get().getShelterId() != applicationRepository.findById(applicationId).get().getShelterId())
            return false;
        Application application = applicationRepository.findById(applicationId).get();
        application.setStatus("rejected");

        String body = "Unfortunately your request for adopting "
                + applicationRepository.findById(applicationId).get().getPetName()
                + " has been denied";
        Notification notification= new Notification(body, "unread");
        int adopterId = applicationRepository.findById(applicationId).get().getAdopterId();
        Adopter adopter = adopterRepository.findById(adopterId).get();
        List<Notification> notifications = adopter.getNotifications();
        notifications.add(notification);
        adopter.setNotifications(notifications);
        return true;
    }

}
