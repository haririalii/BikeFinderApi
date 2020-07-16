package com.police.bikeFinder.bikeFinderApi.repository.impl;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.entity.Client;
import com.police.bikeFinder.bikeFinderApi.entity.Officer;
import org.apache.catalina.core.ApplicationContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
        if(condition == 'a'){
            query = session.createQuery("from Case ");
        }else if(condition == 't'){
            query = session.createQuery("from Case where isAlive = 1");
        }else if (condition == 'f') {
            query = session.createQuery("from Case where isAlive = 0");
        }
        session.close();

        return query.list();

    }

    @Override
    public int addCase(Case myCase) {

        Session session = factory.getCurrentSession();
        session.save(myCase);
        session.close();
        return 0;
    }

    @Override
    public int delCase(int id) {
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
            System.out.println(myCase.getId() + "  " + myCase.getEndDate());
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }
}
