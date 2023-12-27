package com.example.shelters.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "pets")
public class PetController {
    private PetService petService;
    @Autowired
    public PetController(PetService petService){
        this.petService = petService;
    }
    @GetMapping

    public List<Pet> getPets(){
        return petService.getPets();
    }

    @PostMapping(path = "addPet/{staffId}")
    public boolean addPet(@PathVariable int staffId, @RequestBody Pet pet){
        return this.petService.addPet(staffId, pet);
    }
}
