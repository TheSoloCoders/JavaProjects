package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.*;


//@SpringBootApplication
//@ComponentScan()
@Component
public class Main{

        /**
         * The entry point of application.
         *
         * @param args the input arguments
         */
        public static void main(String[] args) {
//            SpringApplication.run(Main.class, args);

            System.out.println("application started !");
//            new Scheduler().extractAndPublishData();
            Map<String, Object> map =new HashMap<>();
            map.put("id",44);
            map.put("date",new Date());
            map.put("name", "aman");
            map.remove("date");

            map.forEach( (k,v) -> {
                System.out.println("Key "+k+ " - "+v);
                map.remove("date");
            });
            System.out.println(map);

//            boolean flag = CheckConditions.processGreaterThanEqualTo(99);

//            System.out.println("Condition = "+flag);


        }

        /**
         * Rest template rest template.
         *
         * @param builder the builder
         * @return the rest template
         */
        @Bean
        public RestTemplate restTemplate(RestTemplateBuilder builder) {
            return builder.build();
        }



//        String s = extractEmailDomain("Rama Rama@gmail.com");
//        final String sort = "aram amam rkhanta h qjqj njqj ajjq qjjq";
//        String[] split = sort.split(" ");
//        String str = sort.split(" ")[0];

//        System.out.println(str);

//        MyEnum myEnum = MyEnum.valueOf(MyEnum.ONE.toString());

//        System.out.println(MyEnum.ONE.days);

//        for (String s1 : split) {
//            try{
//                if(s1.equals("h")){
//                    System.out.println("condition satisfied");
//                    throw new ClassCastException("Not able to cast it");
//                }
//                System.out.println("Inside - "+s1);
//            }catch (Exception ex){
//                System.out.println(ex.getMessage()+" cause -"+ex.getCause());
////                throw new RuntimeException("Ab hmko handle kar to jane");
//            }
//            System.out.println(s1+" - out");
//        }


//        Days.PRINT();

//        String title = StringUtils.capitalize(StringUtils.join(StringUtils.splitByCharacterTypeCamelCase("yourCamelCaseText"), StringUtils.SPACE));
//        System.out.println(title);

//        String emailDomain = "RamaRajuKantji@mgmail.com";
//        String token = emailDomain.substring(0, 3).toUpperCase(Locale.ROOT) + new SimpleDateFormat("yyMMddHHmmss")
//                .format(new Date());
//
//        System.out.println(token);

//         String string =  null;
//            String opt = DigestUtils.md5Hex(string.getBytes(StandardCharsets.UTF_8));
//        System.out.println(string);
//        String s1 = string.trim().replaceAll("[^a-zA-Z0-9 ]", "");

//        System.out.println(s1);
//        if(string.isEmpty())
//            System.out.println( "Output:- "+string);

//        String name = null;

        //add it back internal keys
        //fieldConfigs.addAll(defaultFieldConfigList.stream().filter(fieldConfig -> fieldConfig.getFieldType() == FieldTypeEnum.INTERNAL).toList());

//        String token = "emailVerificationId" + "-" + UUID.randomUUID().toString().replace("-", "");
//        token += "-" + Base64.getEncoder()
//                .encodeToString("cs.amanroy@gamil.com".getBytes(StandardCharsets.UTF_8));
//
//        LocalDate startDate = LocalDate.now().minusDays(2);
//        LocalDate endDate = LocalDate.now();
//        System.out.println("TOKEN:-  "+ startDate.isBefore(endDate));

//        @Scheduled(cron = "0/10 0 * * * *")
//        public void cron() {
//            System.out.println("Starting scheduled job");
//            new Scheduler().method();
//        }

//        int currentHour = LocalTime.now().getHour();
//
//        List<DemoClass> list1 = Arrays.asList(new DemoClass("aman", 2), new DemoClass("Ramna", 3),
//        new DemoClass("Chandan", 4) );
//
//        List<DemoClass> list2 = Arrays.asList( new DemoClass("Ramna", 3),
//                new DemoClass("Chandan", 4),
//                new DemoClass("aman", 2));
//
//        System.out.println("List1 - "+list1.toString());
//        System.out.println("List2 - "+list2.toString());

//        List<Days> list2 = Arrays.asList(Days.TUE,Days.SUN,Days.MON);
//        List<Days> list1 = Arrays.asList(Days.TUE,Days.SUN,Days.WED);


//        List<String> list = null;
////        list.add("");
//
//        System.out.println(list);
//        System.out.println("List is there - "+list == null);


//        Collections.sort(list2);
//        Collections.sort(list1);
//        HashSet<Days> newIntegrations = new HashSet<>(list1.size());
//        newIntegrations.addAll(list2);
//        System.out.println(newIntegrations);
//        list1.forEach( integration -> {
//            if(!newIntegrations.contains(integration)){
//                System.out.println("Not found");
//            }
//        });
//
//        System.out.println("ENUM CHECK _  "+Days.MON.name().equals("MON"));


//        System.out.println(currentHour);
//        System.out.println(currentHour % 3 == 0);


//        Multimap<String, String> map = LinkedHashMultimap.create();
//       newMap.put("aman","1");
//       newMap.put("aman","2");
//
//        System.out.println(newMap);

//        Multimap<String, String> map = LinkedHashMultimap.create();
//        map.put("key1", "value3");
//        map.put("key1", "value1");
//        map.put("key1", "value2");
//        map.put("aman","1");
//        map.put("Aman","2");
//        map.put("aman","3");
//        map.put("aman","3");
//        assertThat((Collection<String>) map.get("key1"))
//                .containsExactly("value3", "value1", "value2");


//        System.out.println(map);
//        Month mo = Month.getByValue("02");
//        System.out.println("Checking enum- "+mo+"-"+02);
//
//        String [] arr = new String[10];
//        arr[0]="aman";
//        List<String> list = Arrays.asList(arr);
//        List<String> list = new ArrayList<>();
//
//        System.out.println(list);
//        list.add("");
//        list.add(null);
//        list.add("ram");
//        list.add("mana");
//        list.add("ram");
//
//        List<String> emailIds = list.stream().distinct().toList();
//        System.out.println(emailIds);
//        System.out.println(list);
//        if(emailIds.size() != list.size()){
//            System.out.println("Email must be unique!");
//        }


//        list.forEach( field -> {
//            if(field == null || field.isBlank()){
//                toRemove.add(field);
//            }
//        });
//        System.out.println(list);
//        System.out.println(toRemove);
//        list.removeAll(toRemove);
//        System.out.println(list);

//        Date date = new Date();
//        long hours = date.getHours();
//        int minutes = date.getMinutes();
//
//        String time=hours+ ":"+minutes;
//        System.out.println("Time - "+time);
//
//        String[] alertTime = time.split(":");
//        LocalTime now = LocalTime.now();
//        System.out.println("Now - "+now);
//        LocalTime alertTimeConfig = LocalTime.of(Integer.parseInt(alertTime[0]), Integer.parseInt(alertTime[1]));
//        System.out.println("time 2- "+alertTimeConfig);
//
//        System.out.println("Result - "+!alertTimeConfig.isAfter(now));

//        LocalTime localTime = LocalTime.parse("02:30");
//        System.out.println("Local - "+localTime);
//        System.out.println("UTC time - " +localTime.minusMinutes(20).toString());

//        Calendar calendar = Calendar.getInstance();
//        // setting last triggered at as cal time
//        calendar.setTime(new Date());
//        System.out.println("date - " +new Date().toString());
//        boolean b = new ImportantNotes().checkHourlyJob(1,calendar);
//
//        String query = "SELECT campaign.id," +
//                "ad_group.name," +
//                "campaign.name," +
//                "ad_group_criterion.keyword.match_type," +
//                "ad_group_criterion.keyword.text," +
//                "ad_group_criterion.negative," +
//                "ad_group_criterion.criterion_id" +
//                "FROM ad_group_criterion " +
//                "WHERE ad_group_criterion.type = 'KEYWORD' AND ad_group_criterion.negative = true";


//        System.out.println("ANS -- "+query );
//
//
//        Map<String,Object> map = (Map<String, Object>) new DemoClass("one",1);
//
//        System.out.println("Map - "+map);
//
//
//
//        List<DemoClass> classes = new ArrayList<>();
//        classes.add(new DemoClass("one",1));
//        classes.add(new DemoClass("one",2));
//        classes.add(new DemoClass("three",3));
//        classes.add(new DemoClass("four",4));
//        classes.add(new DemoClass("six",5));
//        classes.add(new DemoClass("six",6));
//        classes.add(new DemoClass("seven",7));
//
//        System.out.println("list = "+classes.size());
//
//        Set<DemoClass>  uniqueClass = new LinkedHashSet<>(classes);
//
//        System.out.println("unique Class = "+uniqueClass.size());

//        System.out.println("Going to print date--  ");
//        try {
//
//            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
//
//            String dateInString = "31-03-2002";
//            Date date = formatter.parse(dateInString);
//
//            Date prevDate = DateUtils.addDays(date, -1);
//
//            System.out.println("Previous Date - "+ new SimpleDateFormat("MM-dd-yyyy").format(prevDate));
//
//
//        }catch (Exception e){
//
//            System.out.println("Exception while parsing");
//        }



    public static String extractEmailDomain(String emailId) {
        return emailId.substring(emailId.lastIndexOf("@") + 1);

    }

}