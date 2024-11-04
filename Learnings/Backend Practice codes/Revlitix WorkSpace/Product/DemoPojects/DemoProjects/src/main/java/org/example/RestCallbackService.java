package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class RestCallbackService {

    @Autowired
    private RestTemplate restTemplate;

//    @Value("")
//    private String demoDataUrl;
    public void saveDemoDataToDb(DemoData demoData) {

        try{
            System.out.println("going to save data at = "+"localhost:8099/v1/internal/private/add/demo-data");

            ResponseEntity<Object> response = restTemplate.postForEntity("localhost:8099/v1/internal/private/add/demo-data", demoData, Object.class);

            System.out.println("Response - "+response);

        } catch (Exception e){
            System.err.println("Exception occurred while saving data - "+e);
        }

    }

}
