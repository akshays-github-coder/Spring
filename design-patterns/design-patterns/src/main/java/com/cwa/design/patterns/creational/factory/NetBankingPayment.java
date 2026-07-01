package com.cwa.design.patterns.creational.factory;

public class NetBankingPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using Net Banking: " + amount);
    }
}