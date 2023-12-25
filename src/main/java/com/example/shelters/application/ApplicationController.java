package com.example.shelters.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    @PostMapping(path = "apply/{adopterId}/{petId}")
    public boolean applyApplication(
            @PathVariable int adopterId,
            @PathVariable int petId,
            @RequestBody Application application
    ){
        return applicationService.applyApplication(adopterId, petId, application);
    }

    @PutMapping(path = "acceptApplication/{applicationId}")
    public boolean acceptApplication(@PathVariable int applicationId){
        return applicationService.acceptApplication(applicationId);
    }
    @PutMapping(path = "rejectApplication/{applicationId}")
    public boolean rejectApplication(@PathVariable int applicationId){
        return applicationService.rejectApplication(applicationId);
    }

}
