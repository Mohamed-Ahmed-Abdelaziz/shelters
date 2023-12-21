package com.example.shelters.shelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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

}
