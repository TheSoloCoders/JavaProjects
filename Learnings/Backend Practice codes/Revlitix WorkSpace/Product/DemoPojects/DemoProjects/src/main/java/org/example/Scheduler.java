package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Scheduler {


    @Value("#{'${number.demo}'.split(',')}")
    private List<String> numbers;
    public void method(){
        System.out.println("\nRunning in every 10 seconds....");

        numbers.forEach( num -> System.out.println(num));

    }

    public void extractAndPublishData() {
        System.out.println("Going to extract data");
        try {
            List<Map<String, Object>> mapList = CSVToMapConverter.convertCSVToListOfMaps("/home/aman/Desktop/Aman/Revlitix WorkSpace/RevlitixData/google_ads_negative_keyword.csv");

            for (int i = 1; i <= 128; i++) {

                DemoData demoData = new DemoData();
                demoData.setIndex(i);
                demoData.setIntegrationType("GOOGLE_ADS");
                ArrayList<String> dates = new ArrayList<>();
                dates.add("date");
                demoData.setDateAttribute(dates);

                mapList.forEach(map -> {

                    demoData.setData(map);

                    System.out.println("Demo data going to publish = " + demoData);

                    new RestCallbackService().saveDemoDataToDb(demoData);

                });
            }
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
        }
    }

}
