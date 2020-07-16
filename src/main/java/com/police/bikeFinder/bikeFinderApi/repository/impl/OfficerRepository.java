package com.police.bikeFinder.bikeFinderApi.repository.impl;

import com.police.bikeFinder.bikeFinderApi.entity.Officer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OfficerRepository implements com.police.bikeFinder.bikeFinderApi.repository.OfficerRepository {

    @Autowired
    SessionFactory factory;

    @Override
    public List<Officer> getOfficerList() {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Officer") ;

        return query.list();
    }

    @Override
    public int addOfficer(Officer myCase) {
        return 0;
    }

    @Override
    public int delOfficer(int id) {
        return 0;
    }

    @Override
    public Officer getOfficer(int id) {
        return null;
    }

    @Override
    public int updateOfficer(Officer myCase) {
        return 0;
    }
}
