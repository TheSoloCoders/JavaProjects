package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVToMapConverter {

    public static Map<String, String> convertCSVToMap(String filePath) throws IOException {
        Map<String, String> csvMap = new HashMap<>();
        CSVParser parser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withHeader().withTrim());
        for (CSVRecord record : parser) {
            for (String header : parser.getHeaderMap().keySet()) {
                csvMap.put(header, record.get(header));
            }
        }
        return csvMap;
    }

    public static List<Map<String, String>> convertCsvToMap(String filePath) throws IOException {

        List list = new ArrayList();

            Map<String, String> csvMap = new HashMap<>();


        return list;
    }

    public static List<Map<String, Object>> convertCSVToListOfMaps(String filePath) throws IOException {
        List<Map<String, Object>> csvListMap = new ArrayList<>();
        CSVParser parser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withHeader().withTrim());
        for (CSVRecord record : parser) {
            Map<String, Object> recordMap = new HashMap<>();
            for (String header : parser.getHeaderMap().keySet()) {
                recordMap.put(header, record.get(header));
            }
            csvListMap.add(recordMap);
        }
        return csvListMap;
    }


}
