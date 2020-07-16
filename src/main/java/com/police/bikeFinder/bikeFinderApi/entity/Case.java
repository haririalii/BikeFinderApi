package com.police.bikeFinder.bikeFinderApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Date;

//@Entity
public class Case {
    private int id;
    private String description;
    private boolean isAlive;
    private long startDate;
    private long endDate;
    private Client client;

    public Case(String description, Client client) {
        this.description = description;
        this.isAlive = true;
        this.startDate = new Date().getTime();
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = new Date().getTime();
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
