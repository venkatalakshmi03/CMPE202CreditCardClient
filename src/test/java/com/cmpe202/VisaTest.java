package com.cmpe202;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class VisaTest {

    @Test
    void isValidVisaCardNumber16Digits() {
        Visa a = new Visa("4111111111111111", "", "");
        assertThat(a.isValid(), is(true));
        assertThat(a.getCardType(), is(CreditCardType.VISA));
    }

    @Test
    void isValidVisaCardNumber13Digits() {
        Visa a = new Visa("4111111111111", "", "");
        assertThat(a.isValid(), is(true));
        assertThat(a.getCardType(), is(CreditCardType.VISA));
    }

    @Test
    void isValidVisaCardNumber17Digits() {
        Visa a = new Visa("41111111111111111", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidVisaCardNumberNotStartingWith4() {
        Visa a = new Visa("771449635398431", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidBlankCardNumber() {
        Visa a = new Visa("", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }


    @Test
    void isValidNonDigitCardNumber() {
        Visa a = new Visa("4011abcdef", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

}