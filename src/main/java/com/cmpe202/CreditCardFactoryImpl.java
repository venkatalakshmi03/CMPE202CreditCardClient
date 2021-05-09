package com.cmpe202;

public class CreditCardFactoryImpl implements CreditCardFactory {
    @Override
    public CreditCard create(Record r) {
        if (r.getCardNumber() == null || r.getCardNumber().isBlank()) {
            return null;
        }
        try {
            if (Double.valueOf(r.getCardNumber()) != null) {
                if (r.getCardNumber().length() <= 16) {
                    if (r.getCardNumber().length() == 15) {
                        return new AmericanExpress(r.getCardNumber(), r.getExpirationDate(), r.getNameOfCardholder());
                    } else if (r.getCardNumber().length() == 16 && r.getCardNumber().charAt(0) == '5') {
                        return new MasterCard(r.getCardNumber(), r.getExpirationDate(), r.getNameOfCardholder());

                    } else if (r.getCardNumber().length() == 16 && r.getCardNumber().charAt(0) == '6') {
                        return new Discover(r.getCardNumber(), r.getExpirationDate(), r.getNameOfCardholder());

                    } else if ((r.getCardNumber().length() == 13 || r.getCardNumber().length() == 16) && r.getCardNumber().charAt(0) == '4') {
                        return new Visa(r.getCardNumber(), r.getExpirationDate(), r.getNameOfCardholder());
                    }
                }
            }
        } catch (Exception e) {
        }
        return new CreditCard(r.getCardNumber(), r.getExpirationDate(), r.getNameOfCardholder());
    }
}
