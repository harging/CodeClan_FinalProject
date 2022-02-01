package com.codeclan.DiveLog.DiveLog.components;

import com.codeclan.DiveLog.DiveLog.models.*;
import com.codeclan.DiveLog.DiveLog.repositories.CylinderRepository;
import com.codeclan.DiveLog.DiveLog.repositories.DiveRepository;
import com.codeclan.DiveLog.DiveLog.repositories.RegulatorRepository;
import com.codeclan.DiveLog.DiveLog.repositories.SamplePointRepository;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

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
        Dive dive = new Dive(3, new Date(), null, 3,4,5,"Loch Fyne", "dinburgh", null, null, "", 3, 4, 6, 7, "buddy", "", 4.3f, "", 8);
        diveRepository.save(dive);
        SamplePoint sample1 = new SamplePoint(1, dive);
        SamplePoint sample2 = new SamplePoint(2, dive);
        SamplePoint sample3 = new SamplePoint(3, dive);
        SamplePoint sample4 = new SamplePoint(3, dive);
        SamplePoint sample5 = new SamplePoint(2, dive);
        SamplePoint sample6 = new SamplePoint(1, dive);
        samplePointRepository.save(sample1);
        samplePointRepository.save(sample2);
        samplePointRepository.save(sample3);
        samplePointRepository.save(sample4);
        samplePointRepository.save(sample5);
        samplePointRepository.save(sample6);
        samplePointRepository.save(sample1);
        samplePointRepository.save(sample2);
        samplePointRepository.save(sample3);
        samplePointRepository.save(sample4);
        samplePointRepository.save(sample5);
        samplePointRepository.save(sample6);
        Regulator regulator = new Regulator();
        regulatorRepository.save(regulator);
        Cylinder cylinder = new Cylinder(dive, regulator, "Cylinder 1", null, null, null, 6,55, true, 3,6,2,"");
        cylinderRepository.save(cylinder);

        readFromExcel();
    }

    public void readFromExcel() {

//        try {
////            gets the file from the location
//            File fileToRead = new File("/Users/user/FinalProject/divesTest.xlsx");
//            FileInputStream file = new FileInputStream(fileToRead);
////            turns it into a workbook
//            Workbook workbook = new XSSFWorkbook(file);
////            get the first sheet of the workbook
//            Sheet sheet = workbook.getSheetAt(0);
////            goes through each row
//            Iterator<Row> rowIterator = sheet.iterator();
//            int columnIndex;
//            String diveDate = null;
//            int numCellValue;
//            int numColumnIndex;
//            int diveNum = 0;
//
//            while(rowIterator.hasNext()){
//                Row row = rowIterator.next();
////                iterate through the columns for every row
//                Iterator<Cell> cellIterator = row.cellIterator();
//                while(cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
////                    checks the cell type
//                    switch (cell.getCellType()) {
//                        case STRING:
//                            String cellValue = cell.getStringCellValue();
//                            columnIndex = cell.getColumnIndex();
//                            if(columnIndex == 1 && cellValue != "date"){
//                                diveDate = cellValue;
//                            }
//
//                            break;
//                        case NUMERIC:
//                            numCellValue = (int) cell.getNumericCellValue();
//                            numColumnIndex = cell.getColumnIndex();
//                            if(numColumnIndex == 0){
//                                diveNum = numCellValue;
//                            }
//                            break;
//                    }
//                }
//                Dive dive = new Dive(diveNum, new Date(), null, 3,4,5, diveDate, "dinburgh", null, null, "", 3, 4, 6, 7, "buddy", "", 4.3f, "", 8);
//                diveRepository.save(dive);
//            }
//            System.out.println("END");
//            file.close();
//        }
//        catch(FileNotFoundException fne) {
//            fne.printStackTrace();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            FileInputStream file = new FileInputStream(new File("/Users/user/FinalProject/Gavin_dives.xls"));
            Workbook workbook = new HSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            Map<Integer, List<String>> data = new HashMap<>();
            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<String>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING: data.get(i).add(cell.getRichStringCellValue().getString()); break;
                        case NUMERIC: if (DateUtil.isCellDateFormatted(cell)) {
                            data.get(i).add(cell.getDateCellValue() + "");
                        } else {
                            data.get(i).add(cell.getNumericCellValue() + "");
                        } break;
                        case BOOLEAN: data.get(i).add(cell.getBooleanCellValue() + "");
                             break;
                        default: data.get(i).add(" ");
                    }
                }
                i++;
            }
            System.out.println(data);
            createAndSaveObjects(data);
        }
        catch(FileNotFoundException fne) {
            fne.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void createAndSaveObjects(Map data) {
        createAndSaveDive(diveData);
    }
}
