package com.cmpe202;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CreditCardTest {

    @Test
    void isValidCardNumber() {
        CreditCard a = new CreditCard("43qwqerwer356457456", "", "");
        assertThat(a.isValid(), is(true));
        assertThat(a.getCardType(), is(CreditCardType.INVALID));
    }
}