//package com.serverforrest.cardserver.controller;
//
//
//import com.serverforrest.cardserver.entity.Card;
//import com.serverforrest.cardserver.repository.CardRepo;
//import com.serverforrest.cardserver.service.CardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class CardApi {
//    @Autowired
//    private CardService cardService;
////    @Autowired
////    public CardApi(CardService theCardService){
////     this.cardService = theCardService;
////    }
//
//
// //   do we need to inject from persistence layer???
//
//
//
//    @Autowired
//    private CardRepo cardRepo ;
//
//    @GetMapping(value = "/getCards")
//    public List<Card> getCard(){
//        return cardService.findAll();
//    }
//    @GetMapping(value = "/getCards/{dest}")
//    public Card getCardBydest(@PathVariable String dest ){
//        Card theCard = cardService.findByDes(dest);
//        if (theCard == null){
//            throw new RuntimeException("card dest not found"+ dest);
//        }
//        return theCard;
//    }
//    @PostMapping(value = "/cards")
//    public Card addCard(@RequestBody Card thecard){
//        thecard.setDest("0");
//        cardService.save(thecard);
//        return thecard;
//    }
//
//    @DeleteMapping(value = "/getCards/{dest}")
//    public String deletCard(@PathVariable String dest){
//        Card card = cardService.findByDes(dest);
//        if (card == null){
//            throw new RuntimeException("card dest not found"+ dest);
//        }
//        cardService.deleteByDes(dest);
//        return "card"+dest+"deleted";
//    }
//}
