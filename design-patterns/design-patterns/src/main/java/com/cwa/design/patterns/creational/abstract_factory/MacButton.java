package com.cwa.design.patterns.creational.abstract_factory;

public class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("Rendering Mac Button");
    }
}
