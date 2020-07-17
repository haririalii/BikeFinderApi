package com.police.bikeFinder.bikeFinderApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "officer")
public class Officer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String id;
    @Size(min = 5)
    @Column(name = "name")
    private String name;

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "last_mission")
    private long lastMission;

//    @JsonIgnore
    @OneToMany( mappedBy = "officer")
    private List<Case> myCases;

    public Officer(String name) {
        this.name = name;
        this.isAvailable=true;
        this.lastMission = new Date().getTime();
    }

    public Officer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public long getLastMission() {
        return lastMission;
    }

    public void setLastMission(long lastMission) {
        this.lastMission = lastMission;
    }

    public List<Case> MyCases() {
        return myCases;
    }

    public void setMyCase(List<Case> myCases) {
        this.myCases = myCases;
    }
}
