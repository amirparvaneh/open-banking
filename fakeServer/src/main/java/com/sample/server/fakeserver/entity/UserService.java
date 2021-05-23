package com.sample.server.fakeserver.entity;

import com.sample.server.fakeserver.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRep userRep;

    public List<User> getAllUser(){
        return userRep.findAll();
    }
}
