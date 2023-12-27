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
    private String petCareExperience;
    private String petPreferences;
    private String finantialInfo;
    private String lifeStyle;

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

    public Application(String petCareExperience, String petPreferences, String finantialInfo, String lifeStyle) {
        this.petCareExperience = petCareExperience;
        this.petPreferences = petPreferences;
        this.finantialInfo = finantialInfo;
        this.lifeStyle = lifeStyle;
    }

    public Application(String status, String petCareExperience, String petPreferences, String finantialInfo, String lifeStyle, Pet pet, Shelter shelter, Adopter adopter) {
        this.status = status;
        this.petCareExperience = petCareExperience;
        this.petPreferences = petPreferences;
        this.finantialInfo = finantialInfo;
        this.lifeStyle = lifeStyle;
        this.pet = pet;
        this.shelter = shelter;
        this.adopter = adopter;
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

    public String getPetCareExperience() {
        return petCareExperience;
    }

    public void setPetCareExperience(String petCareExperience) {
        this.petCareExperience = petCareExperience;
    }

    public String getPetPreferences() {
        return petPreferences;
    }

    public void setPetPreferences(String petPreferences) {
        this.petPreferences = petPreferences;
    }

    public String getFinantialInfo() {
        return finantialInfo;
    }

    public void setFinantialInfo(String finantialInfo) {
        this.finantialInfo = finantialInfo;
    }

    public String getLifeStyle() {
        return lifeStyle;
    }

    public void setLifeStyle(String lifeStyle) {
        this.lifeStyle = lifeStyle;
    }

    public int getShelterId(){
        return shelter.getShelterId();
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
