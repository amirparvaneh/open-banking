package com.sample.server.fakeserver.entity;

import javax.persistence.*;

@Entity
public class Userr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id ;
    @Column
    private String firstName ;
    @Column
    private String lastName ;

}
