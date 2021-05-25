package com.serverforrest.cardserver.repository;

import com.serverforrest.cardserver.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card,String> {
}
