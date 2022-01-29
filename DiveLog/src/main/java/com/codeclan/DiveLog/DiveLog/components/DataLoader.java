package com.codeclan.DiveLog.DiveLog.components;

import com.codeclan.DiveLog.DiveLog.models.Dive;
import com.codeclan.DiveLog.DiveLog.models.SamplePoint;
import com.codeclan.DiveLog.DiveLog.repositories.DiveRepository;
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

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Dive dive = new Dive();
        dive.setDiveNum(1);
        SamplePoint sample = new SamplePoint(9, dive);
        dive.addSamplePointToProfile(sample);
        diveRepository.save(dive);
        samplePointRepository.save(sample);
        readFromExcel();
    }

    public void readFromExcel() {

    }

//    look for string split function in java for splitting up the list of sample points
}
