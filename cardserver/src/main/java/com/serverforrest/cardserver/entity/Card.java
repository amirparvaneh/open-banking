package com.serverforrest.cardserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "destinationg card number")
    public String dest;
    @Column(name = "first name")
    private String firstName ;
    @Column(name = "last name")
    private String lastName ;
    @Column(name = "Owner Bank")
    private String ownerBank ;
    @Column(name = "Transaction Number")
    private String transactionNumber ;

    public Card() {
    }

    public Card(String dest, String firstName, String lastName, String ownerBank, String transactionNumber) {
        this.dest = dest;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ownerBank = ownerBank;
        this.transactionNumber = transactionNumber;
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

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    @Override
    public String toString() {
        return "Card{" +
                "dest='" + dest + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ownerBank='" + ownerBank + '\'' +
                ", transactionNumber='" + transactionNumber + '\'' +
                '}';
    }
}
