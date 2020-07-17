package com.police.bikeFinder.bikeFinderApi.repository;

import com.police.bikeFinder.bikeFinderApi.entity.Officer;

import java.util.List;

public interface OfficerRepository {
    public List<Officer> getOfficerList();
    public int addOfficer(Officer myOfficer);
    public int delOfficer(int id);
    public Officer getOfficer(int id);
    public int updateOfficer(Officer myOfficer);
    public Officer getBestOfficer ();
}
