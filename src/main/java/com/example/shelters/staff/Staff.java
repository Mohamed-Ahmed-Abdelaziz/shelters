package com.example.shelters.staff;

import com.example.shelters.shelter.Shelter;
import jakarta.persistence.*;

@Entity
@Table
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffId;
    private String email;
    private String password;
    private String name;
    private String role;
    private int contact;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    public Staff() {
    }

    public Staff(String email, String password, String name, String role, int contact, Shelter shelter) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.contact = contact;
        this.shelter = shelter;
    }

    public Staff(String email, String password, String name, String role, int contact) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.contact = contact;
    }

    public Staff(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

//    public Shelter getShelter() {
//        return shelter;
//    }
//
//    public void setShelter(Shelter shelter) {
//        this.shelter = shelter;
//    }
}
