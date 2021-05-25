package com.server.rest.restdata.dao;

import com.server.rest.restdata.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CardRepo extends JpaRepository<Card, String> {
}
