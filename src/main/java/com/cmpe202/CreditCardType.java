package com.cmpe202;

public enum CreditCardType {
    AMEX("AmericanExpress"),
    DISCOVER("Discover"),
    MASTERCARD("MasterCard"),
    VISA("Visa"),
    INVALID("Invalid");

    private CreditCardType(String cardType) {
        this.cardType = cardType;
    }

    private String cardType;
}
