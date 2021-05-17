package com.rest.open.openbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@RestController
public class CardController {

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "https://restcountries.eu/rest/v2/all";
    @GetMapping(path = "/getC")
    public List<Object> getId(){
        Object[] countries = restTemplate.getForObject(url,Object[].class);
        return Arrays.asList(countries);
     }
}
