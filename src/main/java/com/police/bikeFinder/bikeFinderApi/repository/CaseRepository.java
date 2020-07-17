package com.police.bikeFinder.bikeFinderApi.repository;

import com.police.bikeFinder.bikeFinderApi.entity.Case;

import java.util.List;

public interface CaseRepository {
    public List<Case> listCase(char condition);
    public int addCase(Case myCase);
    public int delCase(int id);
    public Case getCase(int id);
    public int updateCase(Case myCase);
    public Case fillCase(Case myCase);
    public void checkUnStartCases();
}
