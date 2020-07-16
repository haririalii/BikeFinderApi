package com.police.bikeFinder.bikeFinderApi.repository;

import com.police.bikeFinder.bikeFinderApi.entity.Client;

import java.util.List;

public interface ClientRepository {
    public List<Client> listClient();
    public int addClient(Client myCase);
    public int delClient(int id);
    public Client getClient(int id);
    public int updateClient(Client myCase);
}
