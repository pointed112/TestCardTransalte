package com.test.card_translate.tests.card.model.impl;

import com.test.card_translate.tests.card.model.CardMethods;
import com.test.card_translate.tests.card.model.BaseParameters;

public class CreditCard extends BaseParameters implements CardMethods {

    private double percent_rate;

    public CreditCard(String name, String currency, double balance, double percent_rate) {
        super(name,currency,balance);
        this.percent_rate=percent_rate;
    }

    public double getPercent_rate() {
        return percent_rate;
    }

    public void setPercent_rate(double percent_rate) {
        this.percent_rate = percent_rate;
    }

    @Override
    public void refillCard() {
        /**
         логика пополнения средств, возможен return нового баланса после пополнения
         */
    }

    @Override
    public void debitCard() {
        /**
         логика списания средств, возможен return нового баланса после списания
         */
    }

    @Override
    public double balanceRequest() {
        return this.getBalance();
    }

    /**
     запрос задолженности
     */
    public void debtRequest() {
    }
}
