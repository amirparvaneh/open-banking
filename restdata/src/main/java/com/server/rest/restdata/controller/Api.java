package com.server.rest.restdata.controller;

import com.server.rest.restdata.entity.Card;
import com.server.rest.restdata.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class Api {

//      private CardService cardService;
//      @Autowired
//      public Api(CardService theCard){
//          cardService = theCard;
//      }
    @GetMapping(value = "/getCard")
    public String getCard(){
        return "asdf";
    }

    @PostMapping(value = "/create",consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Card> getJson(@RequestBody Card card){
        ResponseEntity<Card> responseEntity = ResponseEntity.status(HttpStatus.OK).body(card);
        return responseEntity;
    }


}
