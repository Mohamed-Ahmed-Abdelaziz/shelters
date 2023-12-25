package com.example.shelters.application;

import com.example.shelters.adopter.Adopter;
import com.example.shelters.pet.Pet;
import com.example.shelters.shelter.Shelter;
import jakarta.persistence.*;

@Entity
@Table
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationId;
    private String status;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    @ManyToOne
    @JoinColumn(name = "adopter_id")
    private Adopter adopter;

    public Application() {
    }

    public Application(String status, Pet pet, Shelter shelter, Adopter adopter) {
        this.status = status;
        this.pet = pet;
        this.shelter = shelter;
        this.adopter = adopter;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getPetName(){
        return pet.getName();
    }

//    public Pet getPet() {
//        return pet;
//    }
//
//    public void setPet(Pet pet) {
//        this.pet = pet;
//    }
//
//    public Shelter getShelter() {
//        return shelter;
//    }
//
//    public void setShelter(Shelter shelter) {
//        this.shelter = shelter;
//    }
//
//    public Adopter getAdopter() {
//        return adopter;
//    }
//
//    public void setAdopter(Adopter adopter) {
//        this.adopter = adopter;
//    }
}
