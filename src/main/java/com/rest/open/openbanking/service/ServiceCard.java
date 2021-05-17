package com.rest.open.openbanking.service;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ServiceCard {
    @GetMapping(path = "/rest/v2/all")
    public List<Object> getCountries();

    @GetMapping(path = "/products")
    public List<Object> getProduct();
}

