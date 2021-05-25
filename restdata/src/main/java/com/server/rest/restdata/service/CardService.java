package com.server.rest.restdata.service;

import com.server.rest.restdata.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {
    public List<Card> findAll();
    public Card findByDes(String destinationNumber);
    public void save(Card card);
    public void deleteByDes(String destinationNumber);
}
