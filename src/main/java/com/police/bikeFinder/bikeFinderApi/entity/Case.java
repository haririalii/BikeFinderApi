package com.police.bikeFinder.bikeFinderApi.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "`case`")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @NotNull
    @Size(min=5)
    @Column(name = "description")
    private String description;

    @Column(name = "isAlive")
    private boolean isAlive;

    @Column(name = "start_date")
    private long startDate;

    @Column(name = "end_date")
    private long endDate;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "officer_id")
    public Officer officer;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "`client_id`")
    public Client client;


    public Case() {
    }

    public Case(String description, Client client , Officer officer) {
        this.description = description;
        this.isAlive = true;
        this.startDate = System.currentTimeMillis();
        this.client = client;
        this.officer = officer;
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
//        if (this.startDate <= 0
            this.startDate = System.currentTimeMillis();
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

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }
}
