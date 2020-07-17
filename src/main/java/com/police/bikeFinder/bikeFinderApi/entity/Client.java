package com.police.bikeFinder.bikeFinderApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.police.bikeFinder.bikeFinderApi.validation.NationCodeValidation;
import com.police.bikeFinder.bikeFinderApi.validation.PhoneValidation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "client")
@ApiModel(description = "Client Info")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(hidden = true ,accessMode = ApiModelProperty.AccessMode.READ_ONLY,notes = "Client ID")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @Size(min = 5, message = "Name Should Be More Than 5 Character!")
    @Column(name = "name")
    @ApiModelProperty(notes = "Client Name , it should be more than 5 character")
    private String name;

    @NotNull
    @NationCodeValidation
    @Column(name = "nation_code")
    @ApiModelProperty(notes = "Client NationCode")
    private String nationCode;

    @PhoneValidation
    @Column(name = "phone_number")
    @ApiModelProperty(notes = "Client PhoneNumber")
    private String phoneNumber;


    @OneToMany(mappedBy = "client")
    @ApiModelProperty(hidden =  true,accessMode = ApiModelProperty.AccessMode.READ_ONLY , notes = "Client Cases")
    @JsonIgnore
    private List<Case> casesList;

    public Client() {}

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

    @ApiModelProperty(hidden = true)
    public int getId() {
        return id;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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

    public List<Case> myCases() {
        return casesList;
    }

    public void setCasesList(List<Case> casesList) {
        this.casesList = casesList;
    }
}