package com.example.shelters.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "pets")
public class PetController {
    private PetService petService;
    @Autowired
    public PetController(PetService petService){
        this.petService = petService;
    }
}
