package com.police.bikeFinder.bikeFinderApi.service.impl;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.entity.Client;
import com.police.bikeFinder.bikeFinderApi.repository.ClientRepository;
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
}
