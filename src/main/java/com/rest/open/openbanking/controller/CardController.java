package com.rest.open.openbanking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class CardController {

    @GetMapping(path = "/getOwnerOfCard")
    public String getId(){
        return "this is the information of this owner";
    }
}
