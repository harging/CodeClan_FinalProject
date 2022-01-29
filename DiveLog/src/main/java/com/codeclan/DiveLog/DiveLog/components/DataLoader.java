package com.codeclan.DiveLog.DiveLog.components;

import com.codeclan.DiveLog.DiveLog.models.*;
import com.codeclan.DiveLog.DiveLog.repositories.CylinderRepository;
import com.codeclan.DiveLog.DiveLog.repositories.DiveRepository;
import com.codeclan.DiveLog.DiveLog.repositories.RegulatorRepository;
import com.codeclan.DiveLog.DiveLog.repositories.SamplePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DiveRepository diveRepository;

    @Autowired
    SamplePointRepository samplePointRepository;

    @Autowired
    CylinderRepository cylinderRepository;

    @Autowired
    RegulatorRepository regulatorRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Dive dive = new Dive();
        dive.setDiveNum(1);
        SamplePoint sample = new SamplePoint(9, dive);
        dive.addSamplePointToProfile(sample);
        Cylinder cylinder = new Cylinder();
        Regulator regulator = new Regulator();
        regulator.setValveType(ValveType.DIN);
        dive.addCylinderToCylinders(cylinder);
        regulatorRepository.save(regulator);
        regulator.setCylinder(cylinder);
        diveRepository.save(dive);
        samplePointRepository.save(sample);
        cylinderRepository.save(cylinder);
        cylinder.setDive(dive);

        Dive dive2 = new Dive();
        dive2.setDiveNum(2);
        SamplePoint sample2 = new SamplePoint(1, dive);
        SamplePoint sample3 = new SamplePoint(2, dive);
        SamplePoint sample4 = new SamplePoint(3, dive);
        SamplePoint sample5 = new SamplePoint(4, dive);
        dive.addSamplePointToProfile(sample2);
        dive.addSamplePointToProfile(sample3);
        dive.addSamplePointToProfile(sample4);
        dive.addSamplePointToProfile(sample5);
        Cylinder cylinder2 = new Cylinder();
        Regulator regulator2 = new Regulator();
        regulator2.setValveType(ValveType.DIN);
        dive2.addCylinderToCylinders(cylinder2);
        regulatorRepository.save(regulator2);
        regulator2.setCylinder(cylinder2);
        diveRepository.save(dive2);
        samplePointRepository.save(sample2);
        samplePointRepository.save(sample3);
        samplePointRepository.save(sample4);
        samplePointRepository.save(sample5);
        cylinderRepository.save(cylinder2);
        cylinder2.setDive(dive2);

        readFromExcel();
    }

    public void readFromExcel() {

    }

//    look for string split function in java for splitting up the list of sample points
}
