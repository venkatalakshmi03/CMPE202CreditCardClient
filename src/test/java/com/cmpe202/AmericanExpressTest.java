package com.cmpe202;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AmericanExpressTest {

    @Test
    void isValidAmexCardNumberSecondDigit7() {
        AmericanExpress a = new AmericanExpress("371449635398431", "", "");
        assertThat(a.isValid(), is(true));
        assertThat(a.getCardType(), is(CreditCardType.AMEX));
    }

    @Test
    void isValidAmexCardNumberSecondDigit4() {
        AmericanExpress a = new AmericanExpress("341449635398431", "", "");
        assertThat(a.isValid(), is(true));
        assertThat(a.getCardType(), is(CreditCardType.AMEX));
    }

    @Test
    void isValidAmexCardNumberStartsWith7() {
        AmericanExpress a = new AmericanExpress("771449635398431", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidAmexCardNumberStartsWith4() {
        AmericanExpress a = new AmericanExpress("471449635398431", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidAmexCardNumberSecondDigit2() {
        AmericanExpress a = new AmericanExpress("321449635398431", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidAmexCardNumberLengthGreater15() {
        AmericanExpress a = new AmericanExpress("3414496353984315", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }


    @Test
    void isValidBlankCardNumber() {
        AmericanExpress a = new AmericanExpress("", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidAmexCardNumberLengthOne() {
        AmericanExpress a = new AmericanExpress("3", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidNonDigitCardNumber() {
        AmericanExpress a = new AmericanExpress("4011abcdef", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }
}