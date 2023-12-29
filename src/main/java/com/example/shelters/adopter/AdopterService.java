package com.example.shelters.adopter;

import com.example.shelters.admin.Admin;
import com.example.shelters.admin.AdminRepository;
import com.example.shelters.notification.Notification;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdopterService {
    private final AdopterRepository adopterRepository;
    @Autowired
    public AdopterService(AdopterRepository adopterRepository) {
        this.adopterRepository = adopterRepository;
    }

    public int logIn(Adopter adopter) {
        if(this.adopterRepository.existsByEmail(adopter.getEmail())) {
            if(this.adopterRepository.findByEmail(adopter.getEmail())
                    .get().getPassword().equals(adopter.getPassword())){
                return this.adopterRepository.findByEmail(adopter.getEmail()).get().getAdopterId();
            }
            else {
                throw new IllegalStateException("Password is incorrect");
            }
        } else {
            throw new IllegalStateException("Email does not exist");
        }
    }

    public int signUp(Adopter adopter) {
        if(this.adopterRepository.existsByEmail(adopter.getEmail())){
            throw new IllegalStateException("Email already exists");
        }
        this.adopterRepository.save(adopter);
        return this.adopterRepository.findByEmail(adopter.getEmail()).get().getAdopterId();
    }

    public List<Notification> getUnreadNotifications(int adopterId) {
        List<Notification> unreadNotifications = new ArrayList<>();
        List<Notification> notifications = adopterRepository.findById(adopterId).get().getNotifications();
        for(Notification notification: notifications){
            if(notification.getStatus().equals("unread")){
                unreadNotifications.add(notification);
            }
        }
        return unreadNotifications;
    }

    @Transactional
    public void makeRead(int adopterId, int notificationId) {
        Adopter adopter = adopterRepository.findById(adopterId).get();
        List<Notification> notifications = adopter.getNotifications();
        for(Notification notification: notifications){
            if(notification.getNotificationId() == notificationId){
                notification.setStatus("read");
            }
        }
    }
}
