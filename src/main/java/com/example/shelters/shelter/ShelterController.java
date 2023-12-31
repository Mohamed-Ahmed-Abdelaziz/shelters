package com.example.shelters.shelter;

import com.example.shelters.application.Application;
import com.example.shelters.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "shelters")
public class ShelterController {
    private ShelterService shelterService;
    @Autowired
    public ShelterController(ShelterService shelterService){
        this.shelterService = shelterService;
    }

    @GetMapping
    public List<Shelter> getshelters(){
        return shelterService.getShelters();
    }
    @GetMapping(path = "getPets/{shelterId}")
    public List<Pet> getShelterPets(@PathVariable int shelterId){
        return shelterService.getShelterPets(shelterId);
    }
    @GetMapping(path = "getApplications/{shelterId}")
    public List<Application> getShelterApplications(@PathVariable int shelterId){
        return shelterService.getShelterApplications(shelterId);
    }

}
