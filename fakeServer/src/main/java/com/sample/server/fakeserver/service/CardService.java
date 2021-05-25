package com.sample.server.fakeserver.service;

import com.sample.server.fakeserver.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CardService {
    public List<Card> findAll();
    public Card findByDes(String destinationNumber);
    public void save(Card card);
    public void deleteByDes(String destinationNumber);
}
