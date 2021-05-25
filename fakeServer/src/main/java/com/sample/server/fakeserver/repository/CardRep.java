package com.sample.server.fakeserver.repository;

import com.sample.server.fakeserver.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CardRep extends JpaRepository<Card,String>  {
 }
