package com.example.shelters.adopter;

import com.example.shelters.admin.Admin;
import com.example.shelters.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
    public int logIn(@RequestBody Adopter adopter) throws IOException {
        return adopterService.logIn(adopter);
    }
    @PostMapping("signUp")
    public int signUp(@RequestBody Adopter adopter) throws IOException {
        return adopterService.signUp(adopter);
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
