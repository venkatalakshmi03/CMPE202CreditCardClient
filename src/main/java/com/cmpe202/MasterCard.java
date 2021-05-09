package com.cmpe202;

public class MasterCard extends CreditCard {

    public MasterCard(String cardNumber, String expirationDate, String nameOfCardholder) {
        super(CreditCardType.MASTERCARD, cardNumber, expirationDate, nameOfCardholder);
    }
}
