package com.codeclan.DiveLog.DiveLog.controllers;

import com.codeclan.DiveLog.DiveLog.models.Dive;
import com.codeclan.DiveLog.DiveLog.models.SamplePoint;
import com.codeclan.DiveLog.DiveLog.repositories.DiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DiveController {

    @Autowired
    DiveRepository diveRepository;

    @GetMapping(value = "/dives")
    ResponseEntity<List<Dive>> getAllDives(){
        System.out.println(diveRepository.findAll().get(0).getCylinders());
        return new ResponseEntity<>(diveRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/dives/{id}")
    ResponseEntity <Optional<Dive>> getDiveById(@PathVariable Long id){
        return new ResponseEntity<>(diveRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/dives/{id}/profile")
    ResponseEntity <List<SamplePoint>> getProfileByDiveId(@PathVariable Long id){
        return new ResponseEntity<>(diveRepository.findById(id).get().getProfile(), HttpStatus.OK);
    }
}
