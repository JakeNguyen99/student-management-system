package com.example.studentmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String MotherName;
    private String FartherName;
    private String Address;


    public Parent(String motherName, String fartherName, String address) {
        MotherName = motherName;
        FartherName = fartherName;
        Address = address;
    }

    public Parent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getFartherName() {
        return FartherName;
    }

    public void setFartherName(String fartherName) {
        FartherName = fartherName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
