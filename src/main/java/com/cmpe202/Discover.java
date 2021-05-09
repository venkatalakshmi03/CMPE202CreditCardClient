package com.cmpe202;

public class Discover extends CreditCard {
    public Discover(String cardNumber, String expirationDate, String nameOfCardholder) {
        super(cardNumber, expirationDate, nameOfCardholder);
        if (isValid()) this.setCardType(CreditCardType.DISCOVER);
    }

    @Override
    public boolean isValid() {
        if (getCardNumber().isBlank()) {
            return false;
        }
        try {
            long number = Double.valueOf(getCardNumber()).longValue();
            String value = Long.toString(number);
            if (value.startsWith("6011") && value.length() == 16) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
