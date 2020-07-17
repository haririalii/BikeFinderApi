package com.police.bikeFinder.bikeFinderApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "officer")
@ApiModel
public class Officer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @ApiModelProperty(hidden = true,accessMode = ApiModelProperty.AccessMode.READ_ONLY,notes = "Client ID")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @Size(min = 5)
    @Column(name = "name")
    @ApiModelProperty(notes = "Officer Name , it should be more than 5 Character!")
    private String name;

    @Column(name = "is_available")
    @ApiModelProperty(hidden = true,notes = "Officer Status" , accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean isAvailable;

    @Column(name = "last_mission")
    @ApiModelProperty(hidden = true,notes = "Officer Last Mission" , accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long lastMission;

    @ApiModelProperty(hidden =  true,accessMode = ApiModelProperty.AccessMode.READ_ONLY , notes = "Officer Cases")
    @OneToMany( mappedBy = "officer" )
    @JsonIgnore
    private List<Case> myCases;

    public Officer(String name) {
        this.name = name;
        this.isAvailable=true;
        this.lastMission = new Date().getTime();
    }

    public Officer() {

    }

    public int getId() {
        return id;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public long getLastMission() {
        return lastMission;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void setLastMission(long lastMission) {
        this.lastMission = System.currentTimeMillis();
    }

    public List<Case> MyCases() {
        return myCases;
    }

    public void setMyCase(List<Case> myCases) {
        this.myCases = myCases;
    }
}
