package com.example.shelters.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "applications")
public class ApplicationController {
    private ApplicationService applicationService;
    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }
    @GetMapping
    public List<Application> getApplications(){
        return applicationService.getApplications();
    }
    @PostMapping(path = "apply/{adopterId}/{petId}") // petCareExperience, petPreferences, finantialInfo, lifeStyle
    public boolean applyApplication(
            @PathVariable int adopterId,
            @PathVariable int petId,
            @RequestBody Application application
    ){
        return applicationService.applyApplication(adopterId, petId, application);
    }

    @PutMapping(path = "acceptApplication/{applicationId}/{staffId}")
    public boolean acceptApplication(@PathVariable int applicationId, @PathVariable int staffId){
        return applicationService.acceptApplication(applicationId, staffId);
    }
    @PutMapping(path = "rejectApplication/{applicationId}/{staffId}")
    public boolean rejectApplication(@PathVariable int applicationId, @PathVariable int staffId){
        return applicationService.rejectApplication(applicationId, staffId);
    }

}
