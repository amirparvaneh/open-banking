package com.server.rest.restdata.service;

import com.server.rest.restdata.dao.CardRepo;
import com.server.rest.restdata.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
public class CardServiceImp implements CardService {
    @Autowired
    private CardRepo cardRepo;
    @Autowired
    public CardServiceImp(CardRepo thecardRep){
        cardRepo = thecardRep;
    }
    @Override
    public List<Card> findAll() {
        return cardRepo.findAll();
    }
    @Override
    public Card findByDes(String dest) {
        Optional<Card> result = cardRepo.findById(dest);
        Card theCard = null;

        if (result.isPresent()) {
            theCard = result.get();
        }
        else {
            throw new RuntimeException("Did not find card" +dest);
        }
        return theCard;
    }
    @Override
    public void save(Card card) {
        cardRepo.save(card);
    }
    @Override
    public void deleteByDes(String dest) {
        cardRepo.deleteById(dest);
    }
}
