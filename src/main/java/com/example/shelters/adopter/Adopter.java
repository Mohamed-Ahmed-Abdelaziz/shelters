package com.example.shelters.adopter;

import com.example.shelters.application.Application;
import com.example.shelters.staff.Staff;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Adopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adopterId;
    private String email;
    private String password;
    private String name;
    private int contact;

    @OneToMany(mappedBy = "adopter", cascade = CascadeType.ALL)
    private List<Application> applications;

    public Adopter() {
    }

    public int getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(int adopterId) {
        this.adopterId = adopterId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
