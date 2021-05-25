package com.server.rest.restdata.controller;

import com.server.rest.restdata.entity.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;


@RestController
@RequestMapping(value = "/api")
public class Api {
    @GetMapping(value = "/getCard")
    public String getCard(){
        return "asdf";
    }
    @PostMapping("/")
    public ResponseEntity<Card> create(@RequestBody Card student)
            throws URISyntaxException {
        Card createdStudent = service.create(student);
        if (createdStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdStudent.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdStudent);
        }
    }
}
