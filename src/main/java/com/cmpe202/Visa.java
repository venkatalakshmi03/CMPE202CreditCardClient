package com.cmpe202;

public class Visa extends CreditCard {
    public Visa(String cardNumber, String expirationDate, String nameOfCardholder) {
        super(CreditCardType.VISA, cardNumber, expirationDate, nameOfCardholder);
    }
}
