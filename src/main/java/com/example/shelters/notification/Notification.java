package com.example.shelters.notification;

import com.example.shelters.adopter.Adopter;
import com.example.shelters.shelter.Shelter;
import jakarta.persistence.*;

@Entity
@Table
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;
    private String body;
    private String status;

    public Notification() {
    }

    public Notification(String body, String status) {
        this.body = body;
        this.status = status;
    }
    //    @ManyToOne
//    @JoinColumn(name = "adopter_id", referencedColumnName = "adopterId")
//    private Adopter adopter;

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
