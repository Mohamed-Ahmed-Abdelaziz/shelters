package com.example.shelters.pet;

import com.example.shelters.admin.Admin;
import com.example.shelters.application.Application;
import com.example.shelters.shelter.Shelter;
import jakarta.persistence.*;

@Entity
@Table
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petId;
    private String name;
    private String species;
    private String breed;
    private int age;
    private String gender;
    private String healthStatus;
    private String behaviour;

    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
    private Application application;

    @ManyToOne
    @JoinColumn(name = "shelter_id", referencedColumnName = "shelterId")
    private Shelter shelter;

    public Pet() {
    }

    public Pet(int petId) {
        this.petId = petId;
    }

    public Pet(String name, String species, String breed, int age, String gender, String healthStatus, String behaviour) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.healthStatus = healthStatus;
        this.behaviour = behaviour;
    }
        public Pet(String name, String species, String breed, int age, String gender, String healthStatus, String behaviour, Shelter shelter) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.healthStatus = healthStatus;
        this.behaviour = behaviour;
        this.shelter = shelter;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }
    public int getShelterId(){
        return shelter.getShelterId();
    }

//    public Application getApplication() {
//        return application;
//    }
//
//    public void setApplication(Application application) {
//        this.application = application;
//    }
//
//    public Shelter getShelter() {
//        return shelter;
//    }
//
//    public void setShelter(Shelter shelter) {
//        this.shelter = shelter;
//    }
}
