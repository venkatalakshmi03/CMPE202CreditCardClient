package com.cmpe202;

public class AmericanExpress extends CreditCard {
    public AmericanExpress(String cardNumber, String expirationDate, String nameOfCardholder) {
        super(CreditCardType.AMEX, cardNumber, expirationDate, nameOfCardholder);
    }
}
