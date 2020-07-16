package com.police.bikeFinder.bikeFinderApi.Controller;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MyRestController {

    /*@GetMapping("/users")
    public List getUsers (){
        return ServiceImpl.cases;
    }

    @PostMapping("/users")
    public Case newCase (@RequestBody Case myCase){
        ServiceImpl.cases.add(myCase);
        return myCase;
    }*/

    @PostMapping("/case/new")
    public void getNewCase (@Valid @RequestBody Case newCase){

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
