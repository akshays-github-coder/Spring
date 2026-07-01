package com.cwa.design.patterns.creational.factory;

public class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using Credit Card: " + amount);
    }
}
