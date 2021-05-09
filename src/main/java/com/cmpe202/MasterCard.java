package com.cmpe202;

public class MasterCard extends CreditCard {

    public MasterCard(String cardNumber, String expirationDate, String nameOfCardholder) {
        super(cardNumber, expirationDate, nameOfCardholder);
        if (isValid()) this.setCardType(CreditCardType.MASTERCARD);
    }

    @Override
    public boolean isValid() {
        if (getCardNumber().isBlank()) {
            return false;
        }
        try {
            long number = Double.valueOf(getCardNumber()).longValue();
            String value = Long.toString(number);
            if (value.startsWith("5")
                    && value.length() == 16
                    && (value.charAt(1) == '1' || value.charAt(1) == '2' || value.charAt(1) == '3' || value.charAt(1) == '4' || value.charAt(1) == '5')) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
