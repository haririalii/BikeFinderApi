package com.police.bikeFinder.bikeFinderApi.Controller;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.entity.Client;
import com.police.bikeFinder.bikeFinderApi.entity.Officer;
import com.police.bikeFinder.bikeFinderApi.exception.InvalidInputException;
import com.police.bikeFinder.bikeFinderApi.service.Service;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private Service services ;

    @PostMapping("/case/filing")
    public void getNewCase (@Valid @RequestBody Case newCase,@ApiIgnore Errors bindingResult){
        if (bindingResult.hasErrors())
            throw new InvalidInputException("Invalid Input: ",bindingResult.toString());

        Client cc = services.checkClientAvailable(newCase.getClient());
        if (cc != null)
            newCase.setClient(cc);
        Officer officer;
        try {
            officer = services.getBestOfficer();
        }catch (Exception e){
            throw new InvalidInputException("No officer Available!!","wait till officers get available , try again later!");
        }
        newCase.setOfficer(officer);
        services.addCase(newCase);
        officer.setAvailable(false);
        services.updateOfficer(officer);
    }

    @PostMapping("/case/conclusion")
    public void endCase (@ApiParam(value = "You can Enter Case ID for Close it", example = "1") @RequestHeader int id){
        Case myCase = services.getCase(id);
        if (!myCase.isAlive()) {
            throw new InvalidInputException("invalid ID "," user ID incorrect or this case have already closed");
        }
        myCase.setAlive(false);
        myCase.setEndDate(System.currentTimeMillis());
        myCase.getOfficer().setLastMission(0);
        myCase.getOfficer().setAvailable(true);

        services.updateCase(myCase);
    }



    @GetMapping("/case")
    public List getOpenCase(@ApiParam(value = "you can use:[ alive , end , all ] for this parameter", example = "all") @RequestParam(defaultValue = "all") String condition){
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

    @GetMapping("/officer")
    public List getOfficers (){

        return services.getOfficerList();
    }

    @PostMapping("/officer")
    public void addOfficers (@RequestBody Officer officer){
        services.addOfficer(officer);

    }

    @DeleteMapping("/officer")
    public void delOfficers (@ApiParam(value = "You can Enter Officer ID for Delete it", example = "1")@RequestHeader int id){
        services.delOfficer(id);
    }

    @GetMapping("/officer/cases")
    public List getOfficersCases (@ApiParam(value = "You can Enter Officer ID for Check his Cases", example = "1")@RequestHeader int id){

        return services.getOfficerJobs(id);
    }


}
