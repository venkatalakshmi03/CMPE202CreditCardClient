package com.cmpe202;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DiscoverTest {

    @Test
    void isValidDiscoverCardNumber() {
        Discover a = new Discover("6011111111111117", "", "");
        assertThat(a.isValid(), is(true));
        assertThat(a.getCardType(), is(CreditCardType.DISCOVER));
    }

    @Test
    void isValidDiscoverCardNumber17Digits() {
        Discover a = new Discover("60111111111111178", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidDiscoverCardNumberNotStartingWith6011() {
        Discover a = new Discover("771449635398431", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidBlankCardNumber() {
        Discover a = new Discover("", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidDiscoverCardNumberLengthOne() {
        Discover a = new Discover("3", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void isValidNonDigitCardNumber() {
        Discover a = new Discover("4011abcdef", "", "");
        assertThat(a.isValid(), is(false));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }
}