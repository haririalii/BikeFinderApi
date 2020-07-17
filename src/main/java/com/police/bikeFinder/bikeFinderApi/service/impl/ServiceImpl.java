package com.police.bikeFinder.bikeFinderApi.service.impl;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.entity.Client;
import com.police.bikeFinder.bikeFinderApi.entity.Officer;
import com.police.bikeFinder.bikeFinderApi.repository.ClientRepository;
import com.police.bikeFinder.bikeFinderApi.repository.OfficerRepository;
import com.police.bikeFinder.bikeFinderApi.repository.impl.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceImpl implements com.police.bikeFinder.bikeFinderApi.service.Service {

    @Autowired
    CaseRepository caseRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OfficerRepository officerRepository;

    @Override
    @Transactional
    public List<Case> getCaseList(char condition) {
        return caseRepository.listCase(condition);
    }

    @Override
    @Transactional
    public int addCase(Case newCase) {
        caseRepository.addCase(newCase);
        return 0;
    }

    @Override
    public int deleteCase(int id) {
        caseRepository.delCase(id);
        return 0;
    }

    @Override
    @Transactional
    public Case getCase(int id) {
        return caseRepository.getCase(id);
    }

    @Override
    @Transactional
    public int updateCase(Case myCase)  {
        caseRepository.updateCase(myCase);
        return 0;
    }
/////////////////////////////////////////////////////////////////
    @Override
    public List<Client> getClientList() {
        return clientRepository.listClient();
    }

    @Override
    public int addClient(Client myCase) {
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
        return clientRepository.checkClientAvailable(client);

    }


    //////////////////////////////////////////////////////
    @Override
    public List<Officer> getOfficerList(char condition) {
        return officerRepository.getOfficerList(condition);
    }

    @Override
    public int addOfficer(Officer myOfficer) {
        officerRepository.addOfficer(myOfficer);
        return 0;
    }

    @Override
    public int delOfficer(int id) {
        officerRepository.delOfficer(id);
        return 0;
    }

    @Override
    public Officer getOfficer(int id) {
        return officerRepository.getOfficer(id);
    }

    @Override
    public int updateOfficer(Officer myOfficer) {
        officerRepository.updateOfficer(myOfficer);
        return 0;
    }

    @Override
    public Officer getBestOfficer() {
        return officerRepository.getBestOfficer();
    }

    @Override
    public List getOfficerJobs(int id) {
        return officerRepository.getOfficerJobs(id);
    }

    @Override
    public Case fillCase(Case myCase) {
        return caseRepository.fillCase(myCase);
    }

    @Override
    public void checkUnStartCases() {
        caseRepository.checkUnStartCases();
    }
}
