package com.example.shelters.adopter;

import com.example.shelters.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "adopters")
public class AdopterController {
    private AdopterService adopterService;
    @Autowired
    public AdopterController(AdopterService adopterService){
        this.adopterService = adopterService;
    }

    @PostMapping("logIn")
    public int logIn(@RequestBody Adopter adopter) throws IOException {
        return adopterService.logIn(adopter);
    }
    @PostMapping("signUp")
    public int signUp(@RequestBody Adopter adopter) throws IOException {
        return adopterService.signUp(adopter);
    }
}
