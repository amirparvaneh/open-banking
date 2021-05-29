package com.adddeveloper.finalresttemplate.api;


import com.adddeveloper.finalresttemplate.entity.Card;
import com.adddeveloper.finalresttemplate.entity.CreateCard;
import com.adddeveloper.finalresttemplate.entity.DebitCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api2")
public class Controller {


    private static final String accessToken= "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiI1OTM5OTM0Mjc4OTU0MTg2MCIsInNjb3BlIjpbImNhcmRUcmFuc2ZlcldpdGhNb2JpbGVObyIsImdldENhcmRPd25lciJdLCJjaGFubmVsVHlwZSI6IlNPRlRXQVJFX0FHRU5UIiwiaXNEaXJlY3REZWJpdCI6ZmFsc2UsImV4cCI6MTYyMjg5MzU2MywiYnVzc2luZXNzQnJhbmROYW1lIjoiZ2hvcmJhbmkiLCJqdGkiOiJiYjE1NjU4Mi05YzBmLTRlNTQtOGNjZS0xNjU0MThjYzY0YzYiLCJjdXN0b21lck5vIjoiNTkzOTkzNDI3ODk1NDE4NjAiLCJjbGllbnRfaWQiOiI1OTM5OTM0Mjc4OTU0MTg2MCIsInVzZXJuYW1lIjoiNTkzOTkzNDI3ODk1NDE4NjAifQ.GUHGcxrledBC0yaB2oyrWeR3qnfpcflhrzEfYWwXmQQwRbzT8s6wsFNVxdl24a1j_jgCh6oRuSOBC3ofa30C4skOLG9qfVc-2wJzq3_5KCv8gfAR1yXmteGsbEtAFCVhX1IWnX30RBeCPDoxyXdah3BwaS_eX4HiWtoA4hhCyRPy-hnGNCL1lMdB2t3f3PkVJ4177RsrXKmyDXNDzxWSNDUAn_jCCswUjl8neeuO8NO_u9rMaf6-qeGuh-nfjJoHb7rbz-cQDcdl3nxBiJYxhdqDZgEbnj6b04MdCLQheC_jq8DmRwV6EX6MsCwf2CehrytWX1dIeor4kLAFUNla3Q";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getCard")
    public List<Card> getResponse() {

        String theUrl = "https://jsonplaceholder.typicode.com/todos";
       // String theUrl22 = "https://sandbox.parsian-bank.ir/api/channelServices/1.0/getCardOwner";
        ResponseEntity<List<Card>> response = restTemplate.exchange(theUrl, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Card>>() {
                });
        List<Card> result = response.getBody();
        return result;
    }


    @GetMapping("/getCard/{id}")
    public Card getOneCard(@PathVariable int id) {
        String theUrl2 = "https://jsonplaceholder.typicode.com/todos/" + id;
        ResponseEntity<Card> response2 = restTemplate.exchange(theUrl2,
                HttpMethod.GET, null, Card.class);
        Card card = response2.getBody();
        return card;
    }


    @GetMapping("/getById")
    public Card[] getCardAsArrayObject() {
        String url4 = "https://jsonplaceholder.typicode.com/todos";
        return this.restTemplate.getForObject(url4, Card[].class);
    }

    @GetMapping("/getByOneId/")
    @ResponseBody
    public Card getCardAsOneObject(@RequestParam int id) {
        String url4 = "https://jsonplaceholder.typicode.com/todos/" + id;
        return this.restTemplate.getForObject(url4, Card.class);
    }

    @PostMapping("/create")
    public Card createCard(@RequestBody CreateCard requestBodyCard){
        String theUrl3 = "https://jsonplaceholder.typicode.com/todos";
        HttpEntity<CreateCard> requestCard = new HttpEntity<>(requestBodyCard);
        ResponseEntity<Card> response3 = restTemplate.exchange(theUrl3,
                HttpMethod.POST, requestCard, Card.class);
        return response3.getBody();

    }
    //should use query in this method->
    @PostMapping("/postOneCard")
    public Card getting(@RequestBody int id){
        String theUrl5 = "https://jsonplaceholder.typicode.com/todos/"+id;
        HttpEntity<Integer> requestCard = new HttpEntity<>(id);
        ResponseEntity<Card> cardResponse = restTemplate.exchange(theUrl5,HttpMethod.POST,requestCard,
                Card.class);
        return cardResponse.getBody();
    }


    @PostMapping(value = "/create2",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createOneCard(@RequestBody Card requestBodyCard){
        String theUrl3 = "https://jsonplaceholder.typicode.com/todos";
        ResponseEntity<?> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(requestBodyCard);
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return response;
    }

    @PostMapping("/sandbox")
    public String getPage(@RequestBody String request){
        String urlSandBox0 = "https://sandbox.parsian-bank.ir/api/channelServices/1.0/getCardOwner";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+accessToken);

        HttpEntity<String> entity = new HttpEntity<>(request,headers);
        return restTemplate.postForObject(urlSandBox0, entity, String.class);
    }
    @PostMapping("/sandbox1")
    public DebitCart getCardInSandBox(@RequestBody String request){
        String urlSandBox1 = "https://sandbox.parsian-bank.ir/api/channelServices/1.0/getCardOwner";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+accessToken);

        HttpEntity<String> entity = new HttpEntity<>(request,headers);
        DebitCart result = restTemplate.postForObject(urlSandBox1, entity, DebitCart.class);
        return result;
    }
}
