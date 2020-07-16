package com.police.bikeFinder.bikeFinderApi.repository.impl;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.entity.Client;
import com.police.bikeFinder.bikeFinderApi.entity.Officer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CaseRepository implements com.police.bikeFinder.bikeFinderApi.repository.CaseRepository {

    @Override
    public List<Case> listCustomers() {
        return null;
    }

    @Override
    public int addCase(Case myCase) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Case.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Officer.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();
            Case ccc = new Case("heheheheh", new Client("aliiiiiii","0023269642","09121022154"),new Officer("johndoaaa"));
            session.save(myCase);


            // commit transaction
            session.getTransaction().commit();

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            // handle connection leak issue
            session.close();

            factory.close();
        }
        return 0;
    }

    @Override
    public int delCase(int id) {
        return 0;
    }

    @Override
    public Case getCase(int id) {
        return null;
    }

    @Override
    public int updateCase(Case myCase) {
        return 0;
    }
}
