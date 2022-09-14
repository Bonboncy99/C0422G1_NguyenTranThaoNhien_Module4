package com.codegym.controller;

import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/facilityRest")
public class FacilityRestController {
    @Autowired
    private IFacilityService iFacilityService;
    @GetMapping("")
    public ResponseEntity<Facility> findById(@RequestParam int id){
        Facility facility = this.iFacilityService.findById(id);
        if (facility== null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(facility,HttpStatus.OK);
    }
}
