package com.hashedin.assignment.milestone2.controller;

import com.hashedin.assignment.milestone2.helper.ReadCSV;
import com.hashedin.assignment.milestone2.model.Titles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class NetflixController {

    private List<Titles> netflixList;

    public NetflixController(){
        ReadCSV obj = new ReadCSV();
        netflixList = obj.readFile();
    }

    @GetMapping("/q1/{type}")
    public List query1(@PathVariable("type") String type, @RequestParam(name = "count") String n){

        System.out.println("query1@start");
        try {
            List<Titles> reqestedDataList = netflixList.stream()
                    .filter(title -> title.getType().equalsIgnoreCase(type))
                    .limit(Long.parseLong(n)).collect(Collectors.toList());
            return reqestedDataList;
        } catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            System.out.println("query1@end");
        }
    }

    @GetMapping("/q2/{type}")
    public List query2(@PathVariable("type") String type,@RequestParam(name = "movieType") String listedIn) {
        System.out.println("query2@start");
        try {
            List<Titles> reqestedDataList = netflixList.stream()
                    .filter(title -> (title.getType().equalsIgnoreCase(type) && title.getListedIn().toLowerCase().contains(listedIn.toLowerCase())))
                    .collect(Collectors.toList());
            return reqestedDataList;
        } catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            System.out.println("query2@end");
        }
    }

    @GetMapping("/q3/{type}")
    public List query3(@PathVariable("type") String type,@RequestParam(name = "country") String country) {
        System.out.println("query3@start");
        try {
            List<Titles> reqestedDataList = netflixList.stream()
                    .filter(title -> (title.getType().equalsIgnoreCase(type) && title.getCountry().equalsIgnoreCase(country)))
                    .collect(Collectors.toList());
            return reqestedDataList;
        } catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            System.out.println("query3@end");
        }
    }

    @GetMapping("/q4/{type}")
    public List query4(@PathVariable("type") String type,@RequestParam(name = "startDate") String startDate,@RequestParam(name = "endDate") String endDate) {

        System.out.println("query4@start");
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(type);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date from = format.parse(startDate);
            Date to = format.parse(endDate);

            System.out.println(from);
            System.out.println(to);

            List<Titles> reqestedDataList = netflixList.stream()
                    .filter(title -> (title.getType().equalsIgnoreCase(type)
                            && Optional.ofNullable(title.getDateAdded()).isPresent()
                            && title.getDateAdded().compareTo(from) >= 0
                            && title.getDateAdded().compareTo(to) <= 0))
                    .collect(Collectors.toList());
            return reqestedDataList;
        } catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            System.out.println("query4@end");
        }
    }

//    @GetMapping("/{type}")
//    public List query2(@PathVariable("type") String type, @RequestParam(name = "movieType") String listedIn, @RequestParam(name = "count") String n){
//        List<Titles> reqestedDataList = netflixList.stream()
//                .filter(title -> title.getListedIn().toLowerCase().contains(listedIn.toLowerCase())).limit(Long.parseLong(n)).collect(Collectors.toList());
//        return reqestedDataList;
//    }
}
