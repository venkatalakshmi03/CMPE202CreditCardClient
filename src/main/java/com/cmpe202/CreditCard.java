package com.cmpe202;

public class CreditCard {

    public CreditCard(String cardNumber, String expirationDate, String nameOfCardholder) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.nameOfCardholder = nameOfCardholder;
    }

    public CreditCardType getCardType() {
        return cardType;
    }

    public void setCardType(CreditCardType cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getNameOfCardholder() {
        return nameOfCardholder;
    }

    public void setNameOfCardholder(String nameOfCardholder) {
        this.nameOfCardholder = nameOfCardholder;
    }

    public boolean isValid() {
        return true;
    }

    private CreditCardType cardType = CreditCardType.INVALID;
    private String cardNumber;
    private String expirationDate;
    private String nameOfCardholder;
}
