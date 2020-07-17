package com.police.bikeFinder.bikeFinderApi.repository.impl;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.entity.Client;
import com.police.bikeFinder.bikeFinderApi.entity.Officer;
import com.police.bikeFinder.bikeFinderApi.exception.InvalidInputException;
import com.police.bikeFinder.bikeFinderApi.service.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository()
public class CaseRepository implements com.police.bikeFinder.bikeFinderApi.repository.CaseRepository {

    @Autowired
    SessionFactory factory;

    @Override
    public List<Case> listCase(char condition) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Case") ;

        if(condition == 't') {
            query = session.createQuery("from Case where isAlive = true");
            return query.list();
        }else if(condition == 'f'){
            return session.createQuery("from Case where isAlive = false").list();
        }
        return query.list();
    }

    @Override
    public int addCase(Case myCase) {

            Session session = factory.getCurrentSession();
            myCase.setStartDate(0);
            myCase.setAlive(true);
            session.save(myCase);

        return 0;
    }

    @Override
    public int delCase(int id) {
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Case aCase =null;
            try {
                aCase = getCase(id);
            }catch (Exception e){
                throw new InvalidInputException("Incorrect ID"," no Case with this ID !");
            }
            session.delete(aCase);
            session.getTransaction().commit();
        }catch (Exception e){
            throw new InvalidInputException("cant Delete","invalid id");
        }finally {
            session.close();
        }
        return 0;
    }

    @Override
    public Case getCase(int id) {
        Session session = factory.getCurrentSession();
        return session.get(Case.class,id);

    }

    @Override
    public int updateCase(Case myCase) {
        Session session = factory.getCurrentSession();
        try {session.beginTransaction();
            session.update(myCase);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }


    @Autowired
    private Service services;

    @Override
    public Case fillCase(Case myCase) {
        Client cc = services.checkClientAvailable(myCase.getClient());
        if (cc != null )
            myCase.setClient(cc);

        Officer officer = null;
        try {
            officer = services.getBestOfficer();
        }catch (Exception e){
            myCase.setOfficer(null);
            addCase(myCase);
            throw new InvalidInputException("No officer Available!!","wait till officers get available , it will complete Automatically! ");
        }
        myCase.setOfficer(officer);
        addCase(myCase);
        officer.setAvailable(false);
        services.updateOfficer(officer);
        return myCase;
    }

    @Override
    public void checkUnStartCases() {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Case where officer = null and isAlive = true");
        Case myCase = (Case) query.list().get(0);
        fillCase(myCase);
    }
}
