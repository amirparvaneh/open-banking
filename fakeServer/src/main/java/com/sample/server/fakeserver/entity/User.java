package com.sample.server.fakeserver.entity;


import javax.persistence.*;

@Entity
@Table(name = User.table)
public class User {
    public static final String table = "user";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String destinationCardNumber ;
    @Column(name = "first name")
    private String firstName ;
    @Column(name = "last name")
    private String lastName ;
    @Column(name = "Owner Bank")
    private String ownerBank ;
    @Column(name = "Transaction Number")
    private String transactionNumber ;

    public User() {
    }

    public User(String firstName, String lastName, String ownerBank, String transactionNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ownerBank = ownerBank;
        this.transactionNumber = transactionNumber;
    }

    public String getDestinationCardNumber() {
        return destinationCardNumber;
    }

    public void setDestinationCardNumber(String destinationCardNumber) {
        this.destinationCardNumber = destinationCardNumber;
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
}
