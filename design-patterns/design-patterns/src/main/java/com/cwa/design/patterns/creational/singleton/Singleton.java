package com.cwa.design.patterns.creational.singleton;

public class Singleton {

    // Eager initialization:
    // Object is created when class is loaded.
    private static final Singleton INSTANCE =
            new Singleton();

    // Private constructor prevents direct object creation
    private Singleton() {
        System.out.println("Singleton Constructor Called");
    }

    // Global access point
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
