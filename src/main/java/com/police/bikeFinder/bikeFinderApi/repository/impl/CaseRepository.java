package com.police.bikeFinder.bikeFinderApi.repository.impl;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.exception.InvalidInputException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public class CaseRepository implements com.police.bikeFinder.bikeFinderApi.repository.CaseRepository {

    @Autowired
    SessionFactory factory;

    @Override
    public List<Case> listCase(char condition) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Case") ;

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
}
