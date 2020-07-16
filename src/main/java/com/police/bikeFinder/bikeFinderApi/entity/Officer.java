package com.police.bikeFinder.bikeFinderApi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

//@Entity
public class Officer {
//    @Id
    private String id;
    private String name;
    private boolean isAvailable;
    private long lastMission;

    public Officer(String name) {
        this.name = name;
        this.isAvailable=true;
        this.lastMission = new Date().getTime();
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
}
