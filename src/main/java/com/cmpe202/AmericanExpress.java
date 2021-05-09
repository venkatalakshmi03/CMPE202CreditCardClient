package com.cmpe202;

public class AmericanExpress extends CreditCard {
    public AmericanExpress(String cardNumber, String expirationDate, String nameOfCardholder) {
        super(cardNumber, expirationDate, nameOfCardholder);
        if (isValid()) this.setCardType(CreditCardType.AMEX);
    }

    @Override
    public boolean isValid() {
        if (getCardNumber().isBlank()) {
            return false;
        }
        try {
            long number = Double.valueOf(getCardNumber()).longValue();
            String value = Long.toString(number);
            if (value.length() > 2
                    && (value.charAt(0) == '3') && (value.charAt(1) == '4' || value.charAt(1) == '7')
                    && value.length() == 15) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
