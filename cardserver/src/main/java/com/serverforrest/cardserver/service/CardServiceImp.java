package com.serverforrest.cardserver.service;


import com.serverforrest.cardserver.entity.Card;
import com.serverforrest.cardserver.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CardServiceImp implements CardService {
    private CardRepo cardRep;
    @Autowired
    public CardServiceImp(CardRepo theCardRep){
        this.cardRep = theCardRep;
    }
    @Override
    public List<Card> findAll() {
        return cardRep.findAll();
    }

    @Override
    public Card findByDes(String dest) {
        Optional<Card> result = cardRep.findById(dest);

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
        cardRep.save(card);
    }

    @Override
    public void deleteByDes(String dest) {
        cardRep.deleteById(dest);
    }
}
