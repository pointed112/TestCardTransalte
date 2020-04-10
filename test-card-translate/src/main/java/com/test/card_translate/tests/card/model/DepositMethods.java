package com.test.card_translate.tests.card.model;

public interface DepositMethods {
    /**
     пополнение вклада
     */
    void refillDeposit();
    /**
     запрос баланса
     */
    void balanceRequestDeposit();
    /**
     закрытие вклада
     */
    void closeDeposit();
}
