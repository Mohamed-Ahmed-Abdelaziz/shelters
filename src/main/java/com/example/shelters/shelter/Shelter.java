package com.example.shelters.shelter;

import com.example.shelters.admin.Admin;
import com.example.shelters.application.Application;
import com.example.shelters.pet.Pet;
import com.example.shelters.staff.Staff;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shelterId;
    private String name;
    private String location;
    private String contact;

    @OneToOne(mappedBy = "shelter", cascade = CascadeType.ALL)
    private Admin admin;

    @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL)
    private List<Staff> staffs;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "shelter_id", referencedColumnName = "shelterId")
    @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL)
    private List<Pet> pets;

    @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL)
    private List<Application> applications;

    public Shelter() {
    }

    public Shelter(int shelterId) {
        this.shelterId = shelterId;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

//    public Admin getAdmin() {
//        return admin;
//    }
//
//    public void setAdmin(Admin admin) {
//        this.admin = admin;
//    }
//
//    public List<Staff> getStaffs() {
//        return staffs;
//    }
//
//    public void setStaffs(List<Staff> staffs) {
//        this.staffs = staffs;
//    }
//
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
