package com.test.card_translate.tests.card.model;

public interface CardMethods {
    /**
     пополнение
     */
    void refillCard();
    /**
     списание
     */
    void debitCard();
    /**
     запрос баланса
     */
    double balanceRequest();

}
