package com.cmpe202;

public class Discover extends CreditCard {
    public Discover(String cardNumber, String expirationDate, String nameOfCardholder) {
        super(CreditCardType.DISCOVER, cardNumber, expirationDate, nameOfCardholder);
    }
}
