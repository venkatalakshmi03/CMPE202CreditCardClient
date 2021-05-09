package com.cmpe202;

public class RecordBuilder {
    public Record createRecord() {
        return new Record(cardNumber, expirationDate, nameOfCardholder);
    }

    public RecordBuilder setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public RecordBuilder setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public RecordBuilder setNameOfCardholder(String nameOfCardholder) {
        this.nameOfCardholder = nameOfCardholder;
        return this;
    }

    private String cardNumber;
    private String expirationDate;
    private String nameOfCardholder;
}