package com.cmpe202;

public class Visa extends CreditCard {
    public Visa(String cardNumber, String expirationDate, String nameOfCardholder) {
        super(cardNumber, expirationDate, nameOfCardholder);
        if (isValid()) this.setCardType(CreditCardType.VISA);
    }

    @Override
    public boolean isValid() {
        if (getCardNumber().isBlank()) {
            return false;
        }
        try {
            long number = Double.valueOf(getCardNumber()).longValue();
            String value = Long.toString(number);
            if ((value.length() == 13 || value.length() == 16) && value.charAt(0) == '4') {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
