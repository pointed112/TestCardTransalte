package com.test.card_translate.tests.card.model.impl;

import com.test.card_translate.tests.card.model.BaseParameters;
import com.test.card_translate.tests.card.model.DepositMethods;

public class Deposit extends BaseParameters implements DepositMethods {

    public Deposit(String name, String currency, double balance) {
        super(name, currency, balance);
    }

    @Override
    public void refillDeposit() {

    }

    @Override
    public void balanceRequestDeposit() {

    }

    @Override
    public void closeDeposit() {

    }
}
