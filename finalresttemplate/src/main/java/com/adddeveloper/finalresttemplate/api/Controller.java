package com.adddeveloper.finalresttemplate.api;


import com.adddeveloper.finalresttemplate.entity.Card;
import com.adddeveloper.finalresttemplate.entity.CreateCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/api2")
public class Controller {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getCard")
    public List<Card> getResponse(){

        String theUrl = "https://jsonplaceholder.typicode.com/todos";
        ResponseEntity<List<Card>> response = restTemplate.exchange(theUrl, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Card>>() {
        });
        List<Card> result = response.getBody();
        return result;
    }

    @GetMapping("/getCard/{id}")
    public Card getOneCard(@PathVariable int id){
        String theUrl2 = "https://jsonplaceholder.typicode.com/todos/"+ id ;
        ResponseEntity<Card> response2 = restTemplate.exchange(theUrl2,
                HttpMethod.GET , null , Card.class);
        Card card = response2.getBody();
        return card;
    }

    @PostMapping("/create")
    public Card createCard(@RequestBody CreateCard requestBodyCard){
        String theUrl3 = "https://jsonplaceholder.typicode.com/todos";
        HttpEntity<CreateCard> requestCard = new HttpEntity<>(requestBodyCard);
        ResponseEntity<Card> response3 = restTemplate.exchange(theUrl3,
                HttpMethod.POST, requestCard, Card.class);
        return response3.getBody();
    }
}
