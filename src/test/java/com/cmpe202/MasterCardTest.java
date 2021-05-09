package com.cmpe202;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MasterCardTest {
    @Test
    void isValidMasterCardCardNumberSecondDigit1() {
        MasterCard a = new MasterCard("5155555555554444", "", "");
        assertThat(a.isValid(), is(true));
        assertThat(a.getCardType(), is(CreditCardType.MASTERCARD));
    }

    @Test
    void isValidMasterCardCardNumberSecondDigit2() {
        MasterCard a = new MasterCard("5255555555554444", "", "");
        assertThat(a.isValid(), is(true));
        assertThat(a.getCardType(), is(CreditCardType.MASTERCARD));
    }

    @Test
    void isValidMasterCardCardNumberSecondDigit3() {
        MasterCard a = new MasterCard("5355555555554444", "", "");
        assertThat(a.isValid(), is(true));
        assertThat(a.getCardType(), is(CreditCardType.MASTERCARD));
    }

    @Test
    void isValidMasterCardCardNumberSecondDigit4() {
        MasterCard a = new MasterCard("5455555555554444", "", "");
        assertThat(a.isValid(), is(true));
        assertThat(a.getCardType(), is(CreditCardType.MASTERCARD));
    }

    @Test
    void isValidMasterCardCardNumberSecondDigit5() {
        MasterCard a = new MasterCard("5555555555554444", "", "");
        assertThat(a.isValid(), is(true));
        assertThat(a.getCardType(), is(CreditCardType.MASTERCARD));
    }


    @Test
    void isValidMasterCardCardNumber17Digits() {
        MasterCard a = new MasterCard("55555555555544447", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidMasterCardCardNumberNotStartingWith5() {
        MasterCard a = new MasterCard("771449635398431", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidBlankCardNumber() {
        MasterCard a = new MasterCard("", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidMasterCardCardNumberLengthOne() {
        MasterCard a = new MasterCard("3", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidNonDigitCardNumber() {
        MasterCard a = new MasterCard("4011abcdef", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }
}