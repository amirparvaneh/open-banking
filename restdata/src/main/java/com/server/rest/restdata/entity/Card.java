package com.server.rest.restdata.entity;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "destination number")
    private String dest;
    @Column(name = "first name")
    private String firstName;
    @Column(name = "last name")
    private String lastName;
    @Column(name = "owner bank")
    private String ownerBank;
    @Column(name = "transaction Number")
    private String transactionNum;

    public Card() {
    }

    public Card(String dest, String firstName, String lastName, String ownerBank, String transactionNum) {
        this.dest = dest;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ownerBank = ownerBank;
        this.transactionNum = transactionNum;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOwnerBank() {
        return ownerBank;
    }

    public void setOwnerBank(String ownerBank) {
        this.ownerBank = ownerBank;
    }

    public String getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(String transactionNum) {
        this.transactionNum = transactionNum;
    }
}
