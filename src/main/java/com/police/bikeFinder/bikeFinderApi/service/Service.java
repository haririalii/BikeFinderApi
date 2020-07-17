package com.police.bikeFinder.bikeFinderApi.service;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.entity.Client;
import com.police.bikeFinder.bikeFinderApi.entity.Officer;

import java.util.List;

public interface Service {
    public List<Case> getCaseList (char condition);
    public int addCase (Case newCase);
    public int deleteCase (int id);
    public Case getCase (int id);
    public int updateCase(Case myCase);
    public List<Client> getClientList();
    public int addClient(Client myCase);
    public int delClient(int id);
    public Client getClient(int id);
    public int updateClient(Client myCase);
    public Client checkClientAvailable (Client client);

    public List<Officer> getOfficerList(char condition);
    public int addOfficer(Officer myOfficer);
    public int delOfficer(int id);
    public Officer getOfficer(int id);
    public int updateOfficer(Officer myOfficer);
    public Officer getBestOfficer ();
    public List getOfficerJobs(int id);
    public Case fillCase (Case myCase);
    public void checkUnStartCases();
}
