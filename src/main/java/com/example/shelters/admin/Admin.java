package com.example.shelters.admin;

import com.example.shelters.adopter.Adopter;
import com.example.shelters.shelter.Shelter;
import jakarta.persistence.*;

@Entity
@Table
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "shelter_id")
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "admin_id", referencedColumnName = "adminId")
    private Shelter shelter;

    public Admin() {
    }

    public Admin(int adminId) {
        this.adminId = adminId;
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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

//    public Shelter getShelter() {
//        return shelter;
//    }
//
    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }
    public int getShelterId(){
        return shelter.getShelterId();
    }
}
