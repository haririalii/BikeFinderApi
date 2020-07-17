package com.police.bikeFinder.bikeFinderApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "`case_table`")
@ApiModel(description = "Cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(hidden = true,accessMode = ApiModelProperty.AccessMode.READ_ONLY,notes = "Case ID")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

//    @NotNull
    @Size(min=5)
    @Column(name = "description")
    @ApiModelProperty(notes = "Case Description")
    private String description;

    @Column(name = "isAlive")
    @ApiModelProperty(hidden = true,accessMode = ApiModelProperty.AccessMode.READ_ONLY,notes = "show Is Case Alive")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean isAlive;

    @Column(name = "start_date")
    @ApiModelProperty(hidden = true,accessMode = ApiModelProperty.AccessMode.READ_ONLY,notes = "Starting date of Case in Millis")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long startDate;

    @Column(name = "end_date")
    @ApiModelProperty(hidden = true,notes = "Starting date of Case in Millis")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long endDate;

    @Valid
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "`officer_id`")
    @ApiModelProperty(hidden = true)

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Officer officer;

    @Valid
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "`client_id`")
    @ApiModelProperty(notes = "Client info")

    public Client client;


    public Case() {
        setStartDate(0);
        setAlive(true);
    }

    public Case(String description, Client client , Officer officer) {
        this.description = description;
        this.isAlive = true;
        this.startDate = System.currentTimeMillis();
        this.client = client;
        this.officer = officer;
    }
    @ApiModelProperty(hidden = true)
    public int getId() {
        return id;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @ApiModelProperty(hidden = true)
    public boolean isAlive() {
        return isAlive;
    }
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    @ApiModelProperty(hidden = true)
    public long getStartDate() {
        return startDate;
    }
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void setStartDate(long startDate) {
//        if (this.startDate <= 0
            this.startDate = System.currentTimeMillis();
    }@ApiModelProperty(hidden = true)
    public long getEndDate() {
        return endDate;
    }
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    @ApiModelProperty(hidden = true)
    public Officer getOfficer() {
        return officer;
    }
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public void setOfficer(Officer officer) {
        this.officer = officer;
    }
}
