package org.example;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class ImportantNotes {

    /**
     * Task api call back string.
     *
     * @param createTask the create task
     * @return the string

    private String taskApiCallBack(CreateTask createTask) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + loggedInUserService.getAccessToken());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity httpEntity = new HttpEntity<>(createTask, headers);
        return restTemplate.exchange(taskApiEndpoint, HttpMethod.POST, httpEntity, String.class).getBody();
    }

     */

    public boolean checkHourlyJob(int now, Calendar calendar) {
        int lastTriggeredHour = calendar.get(Calendar.HOUR);
        int currentHour = LocalTime.now().getHour();

        if (currentHour == lastTriggeredHour) {
            System.out.println("Job is already triggered today");
            return false;
        } else {
            // checking the time is elapsed or not
            return currentHour %  now == 0;
        }
    }


}
