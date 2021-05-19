package com.sample.server.fakeserver.repository;

import com.sample.server.fakeserver.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<Userr,Long> {
}
