package com.example.shelters.adopter;

import com.example.shelters.admin.Admin;
import com.example.shelters.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping(path = "adopters")
public class AdopterController {
    private AdopterService adopterService;
    @Autowired
    public AdopterController(AdopterService adopterService){
        this.adopterService = adopterService;
    }

    @PostMapping("logIn")
    public ResponseEntity<Object> logIn(@RequestBody Adopter adopter) throws IOException {
        try {
            return new ResponseEntity<>(adopterService.logIn(adopter), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), org.springframework.http.HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("signUp")
    public ResponseEntity<String> signUp(@RequestBody Adopter adopter) throws IOException {
        try {
            adopterService.signUp(adopter);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), org.springframework.http.HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Adopter created successfully", org.springframework.http.HttpStatus.CREATED);
    }
    @GetMapping("unreadNotifications/{adopterId}")
    public List<Notification> getUnreadNotifications(@PathVariable int adopterId){
        return adopterService.getUnreadNotifications(adopterId);
    }
    @PutMapping("makeRead/{adopterId}/{notificationId}")
    public void makeRead(@PathVariable int adopterId, @PathVariable int notificationId){
        adopterService.makeRead(adopterId, notificationId);
    }
}
