package com.test.card_translate.tests.card.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseParameters {
    private String name;
    private String currency;
    private double balance;

    public BaseParameters (String name, String currency, double balance){
        this.name = name;
        this.currency=currency;
        this.balance=balance;
    }
}
