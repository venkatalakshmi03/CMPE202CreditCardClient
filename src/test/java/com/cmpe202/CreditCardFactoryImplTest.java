package com.cmpe202;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class CreditCardFactoryImplTest {

    @Test
    void createDiscover() {
        CreditCardFactoryImpl cf = new CreditCardFactoryImpl();
        Record r = new RecordBuilder().setCardNumber("6011111111111117").setExpirationDate("3/20/2030").setNameOfCardholder("Alice").createRecord();
        CreditCard c = cf.create(r);
        assertThat(c, is(instanceOf(Discover.class)));
        assertThat(c.getCardType(), is(CreditCardType.DISCOVER));
    }

    @Test
    void createAmex() {
        CreditCardFactoryImpl cf = new CreditCardFactoryImpl();
        Record r = new RecordBuilder().setCardNumber("371449635398431").setExpirationDate("3/20/2030").setNameOfCardholder("Alice").createRecord();
        CreditCard c = cf.create(r);
        assertThat(c, is(instanceOf(AmericanExpress.class)));
        assertThat(c.getCardType(), is(CreditCardType.AMEX));
    }

    @Test
    void createMasterCard() {
        CreditCardFactoryImpl cf = new CreditCardFactoryImpl();
        Record r = new RecordBuilder().setCardNumber("5155555555554444").setExpirationDate("3/20/2030").setNameOfCardholder("Alice").createRecord();
        CreditCard c = cf.create(r);
        assertThat(c, is(instanceOf(MasterCard.class)));
        assertThat(c.getCardType(), is(CreditCardType.MASTERCARD));
    }

    @Test
    void createVisa() {
        CreditCardFactoryImpl cf = new CreditCardFactoryImpl();
        Record r = new RecordBuilder().setCardNumber("4111111111111").setExpirationDate("3/20/2030").setNameOfCardholder("Alice").createRecord();
        CreditCard c = cf.create(r);
        assertThat(c, is(instanceOf(Visa.class)));
        assertThat(c.getCardType(), is(CreditCardType.VISA));
    }

    @Test
    void createInvalidWithInvalidNumber() {
        CreditCardFactoryImpl cf = new CreditCardFactoryImpl();
        Record r = new RecordBuilder().setCardNumber("9011111111111117").setExpirationDate("3/20/2030").setNameOfCardholder("Alice").createRecord();
        CreditCard c = cf.create(r);
        assertThat(c, is(instanceOf(CreditCard.class)));
        assertThat(c.getCardType(), is(CreditCardType.INVALID));
    }

    @Test
    void createInvalidWithBlankCard() {
        CreditCardFactoryImpl cf = new CreditCardFactoryImpl();
        Record r = new RecordBuilder().setCardNumber("").setExpirationDate("3/20/2030").setNameOfCardholder("Alice").createRecord();
        CreditCard c = cf.create(r);
        assertThat(c, is(nullValue()));
    }
}