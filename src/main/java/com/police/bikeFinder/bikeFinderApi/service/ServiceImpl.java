package com.police.bikeFinder.bikeFinderApi.service;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.entity.Client;

import java.util.LinkedList;

public class ServiceImpl {
    public static LinkedList<Case> cases = new LinkedList<>();
    static {
        cases.add(new Case("hello" , new Client("ali","002","0912")));
        cases.add(new Case("hellooo" , new Client("alii","003","0913")));
    }
}
