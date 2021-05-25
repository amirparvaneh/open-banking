package com.sample.server.fakeserver.service;

import com.sample.server.fakeserver.entity.Card;
import com.sample.server.fakeserver.repository.CardRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CardServiceImp implements CardService {

    private CardRep cardRep;
    @Autowired
    public CardServiceImp(CardRep thecardRep){
        cardRep = thecardRep;
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
