package com.example.shelters.adopter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "adopters")
public class AdopterController {
    private AdopterService adopterService;
    @Autowired
    public AdopterController(AdopterService adopterService){
        this.adopterService = adopterService;
    }
}
