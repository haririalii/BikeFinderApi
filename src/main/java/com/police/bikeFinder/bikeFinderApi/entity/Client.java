package com.police.bikeFinder.bikeFinderApi.entity;

import com.police.bikeFinder.bikeFinderApi.validation.NationCodeValidation;
import com.police.bikeFinder.bikeFinderApi.validation.PhoneValidation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

//    @NotNull
    @Size(min=5 , message = "Name Should Be More Than 5 Character!")
    @Column(name = "name")
    private String name;

    @NationCodeValidation
    @Column(name = "nation_code")
    private String nationCode;

    @NotNull
    @PhoneValidation
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "client")
    private Case casee ;

    public Client(String name, String nationCode, String phoneNumber) {
        this.name = name;
        this.nationCode = nationCode;
        this.phoneNumber = phoneNumber;
    }

    public Case getCasee() {
        return casee;
    }

    public void setCasee(Case casee) {
        this.casee = casee;
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

    public Client() {
    }
}
