package com.police.bikeFinder.bikeFinderApi.Controller;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.exception.InvalidInputException;
import com.police.bikeFinder.bikeFinderApi.repository.CaseRepository;
import com.police.bikeFinder.bikeFinderApi.service.impl.ServiceImpl;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@RestController
public class MyRestController {

    @GetMapping("/users")
    public List getUsers (){
        return ServiceImpl.cases;
    }

    @Autowired
    CaseRepository caseRepository ;
    @PostMapping("/users")
    public void newCase (@Valid @RequestBody Case myCase , Errors bindingResult){
        ServiceImpl.cases.add(myCase);

        if (bindingResult.hasErrors())
            throw new InvalidInputException("Invalid Input: ",bindingResult.toString());
//        return myCase;
    }

    @PostMapping("/case/new")
    public void getNewCase (@Valid @RequestBody Case newCase, Errors bindingResult){
        if (bindingResult.hasErrors())
            throw new InvalidInputException("Invalid Input: ",bindingResult.toString());
        caseRepository.addCase(newCase);
    }

    @PostMapping("/case/conclusion")
    public void endCase (){

    }

    @GetMapping("/case")
    public void getOpenCase(@RequestParam String condition){
        /*if(condition.equals("end"))
            return "ending cases";
        else if (condition.equals("alive")){
            return "alive case";
        }
        return "nothing";*/
    }


}
