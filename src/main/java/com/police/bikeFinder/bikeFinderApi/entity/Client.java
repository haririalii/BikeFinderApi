package com.police.bikeFinder.bikeFinderApi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Client {
//    @Id
    private int id;
    private String name;
    private String nationCode;
    private String phoneNumber;

    public Client(String name, String nationCode, String phoneNumber) {
        this.name = name;
        this.nationCode = nationCode;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
