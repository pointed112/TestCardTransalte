package com.test.card_translate.tests.card.model.impl;

import com.test.card_translate.tests.card.model.CardMethods;
import com.test.card_translate.tests.card.model.BaseParameters;

public class DebitCard extends BaseParameters implements CardMethods {

    public DebitCard(String name, String currency, double balance) {
        super(name,currency,balance);
    }

    @Override
    public void refillCard() {

    }

    @Override
    public void debitCard() {

    }

    @Override
    public double balanceRequest() {
        return this.getBalance();
    }
}
