package com.police.bikeFinder.bikeFinderApi.Controller;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.exception.InvalidInputException;
import com.police.bikeFinder.bikeFinderApi.repository.CaseRepository;
import com.police.bikeFinder.bikeFinderApi.service.Service;
import com.police.bikeFinder.bikeFinderApi.service.impl.ServiceImpl;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class MyRestController {

   /* @GetMapping("/users")
    public List getUsers (){
        return null;
    }
    @PostMapping("/users")
    public void newCase (@Valid @RequestBody Case myCase , Errors bindingResult){
//        ServiceImpl.cases.add(myCase);

        if (bindingResult.hasErrors())
            throw new InvalidInputException("Invalid Input: ",bindingResult.toString());
//        return myCase;
    }*/
    @Autowired
    private Service services ;


    @PostMapping("/case/new")
    public void getNewCase (@Valid @RequestBody Case newCase, Errors bindingResult){
        if (bindingResult.hasErrors())
            throw new InvalidInputException("Invalid Input: ",bindingResult.toString());
//        newCase.setStartDate(0);
        services.addCase(newCase);
        System.out.println(newCase.getStartDate());
    }

    @PostMapping("/case/conclusion")
    public void endCase (@RequestParam int id){
        Case myCase = services.getCase(id);
        myCase.setAlive(false);
        myCase.setEndDate(System.currentTimeMillis());
        services.updateCase(myCase);

    }

    @GetMapping("/case")
    public List getOpenCase(@RequestParam String condition){
        if(condition.equals("end"))
            return services.getCaseList('f');
        else if (condition.equals("alive")){
            return services.getCaseList('t');
        }
        return services.getCaseList('a');
    }

    @GetMapping("/client")
    public List getClients (){
        return services.getClientList();
    }


}
