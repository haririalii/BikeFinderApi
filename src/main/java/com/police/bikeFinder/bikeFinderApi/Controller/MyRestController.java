package com.police.bikeFinder.bikeFinderApi.Controller;

import com.police.bikeFinder.bikeFinderApi.entity.Case;
import com.police.bikeFinder.bikeFinderApi.entity.Officer;
import com.police.bikeFinder.bikeFinderApi.exception.InvalidInputException;
import com.police.bikeFinder.bikeFinderApi.service.Service;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private Service services ;

    @PostMapping("/case/fill")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Case getNewCase (@Valid @RequestBody Case newCase, @ApiIgnore Errors bindingResult){
        if (bindingResult.hasErrors())
            throw new InvalidInputException("Invalid Input: ",bindingResult.toString());

            return services.fillCase(newCase);
    }

    @PostMapping("/case/conclusion")
    @ApiResponse(code = 200, message = " ")
    public RedirectView endCase (@ApiParam(value = "You can Enter Case ID for Close it", example = "1") @RequestHeader int id){
        Case myCase = services.getCase(id);
        if (!myCase.isAlive()) {
            throw new InvalidInputException("invalid ID "," user ID incorrect or this case have already closed");
        }
        myCase.setAlive(false);
        myCase.setEndDate(System.currentTimeMillis());
        myCase.getOfficer().setLastMission(0);
        myCase.getOfficer().setAvailable(true);

        services.updateCase(myCase);


        return new RedirectView("/case/update");
    }

    @GetMapping("/case/update")
    @ApiIgnore
    public void update(){
       try {
           services.checkUnStartCases();
       }catch (IndexOutOfBoundsException e){

       }
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
    public List getOfficers (@ApiParam(value = "you can use:[ available , busy , all ] for this parameter", example = "all") @RequestParam(defaultValue = "all") String condition){
        if(condition.equals("busy"))
            return services.getOfficerList('f');
        else if (condition.equals("available")){
            return services.getOfficerList('t');
        }
        return services.getOfficerList('a');
    }

    @PostMapping("/officer")
    @ResponseStatus(code = HttpStatus.CREATED)
    public RedirectView addOfficers (@RequestBody Officer officer){
        services.addOfficer(officer);

        return new RedirectView("/case/update");

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
