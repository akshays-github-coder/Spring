package com.cwa.design.patterns.creational.factory;

public class PaymentFactory {

    public static Payment getPayment(String type) {

        if ("UPI".equalsIgnoreCase(type)) {
            return new UpiPayment();
        }

        if ("CARD".equalsIgnoreCase(type)) {
            return new CreditCardPayment();
        }

        if ("NETBANKING".equalsIgnoreCase(type)) {
            return new NetBankingPayment();
        }

        throw new IllegalArgumentException(
                "Invalid Payment Type");
    }
}
