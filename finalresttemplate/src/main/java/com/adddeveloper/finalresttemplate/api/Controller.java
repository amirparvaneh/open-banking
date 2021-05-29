package com.adddeveloper.finalresttemplate.api;


import com.adddeveloper.finalresttemplate.entity.Card;
import com.adddeveloper.finalresttemplate.entity.CreateCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api2")
public class Controller {


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
    public Object getPage(@RequestBody Object request){
        String urlSandBox = "https://sandbox.parsian-bank.ir/api/channelServices/1.0/getCardOwner";
        Object object = restTemplate.postForObject(urlSandBox,request,Object.class);
        return object;
    }
}
