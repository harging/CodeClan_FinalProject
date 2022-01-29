package com.codeclan.DiveLog.DiveLog.controllers;

import com.codeclan.DiveLog.DiveLog.models.Cylinder;
import com.codeclan.DiveLog.DiveLog.models.SamplePoint;
import com.codeclan.DiveLog.DiveLog.repositories.CylinderRepository;
import com.codeclan.DiveLog.DiveLog.repositories.SamplePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CylinderController {

    @Autowired
    CylinderRepository cylinderRepository;

    @GetMapping(value = "/cylinders")
    ResponseEntity<List<Cylinder>> getAllCylinders(){
        return new ResponseEntity<>(cylinderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/cylinders/{id}")
    ResponseEntity<Optional<Cylinder>> getCylinderById(@PathVariable Long id){
        return new ResponseEntity<>(cylinderRepository.findById(id), HttpStatus.OK);
    }
}
