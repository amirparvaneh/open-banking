package com.adddeveloper.finalresttemplate.entity;

public class DebitCart {
    private String firstName ;
    private String lastName ;
    private String ownerBankName;
    private String transactionNumber;

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

    public String getOwnerBankName() {
        return ownerBankName;
    }

    public void setOwnerBankName(String ownerBankName) {
        this.ownerBankName = ownerBankName;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }
}
