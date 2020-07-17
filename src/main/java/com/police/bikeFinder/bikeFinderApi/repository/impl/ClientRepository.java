package com.police.bikeFinder.bikeFinderApi.repository.impl;

import com.police.bikeFinder.bikeFinderApi.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository implements com.police.bikeFinder.bikeFinderApi.repository.ClientRepository {

    @Autowired
    SessionFactory factory;

    @Override
    public List<Client> listClient() {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Client ") ;
        return query.list();
    }

    @Override
    public int addClient(Client myCase) {
        Session session = factory.getCurrentSession();
        session.save(myCase);
        return 0;
    }

    @Override
    public int delClient(int id) {
        return 0;
    }

    @Override
    public Client getClient(int id) {
        return null;
    }

    @Override
    public int updateClient(Client myCase) {
        return 0;
    }

    @Override
    public Client checkClientAvailable(Client client) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from Client where name = :cname and nationCode = :cnationCode and phoneNumber = :cphoneNumber");
        query.setParameter("cname",client.getName());
        query.setParameter("cnationCode",client.getNationCode());
        query.setParameter("cphoneNumber",client.getPhoneNumber());


        try {
            Client client1 = (Client) query.list().get(0);
            if (client1 != null)
                return client1;

        }catch (Exception e) {
            return client;
        }
        return null;
    }
}
