package com.cwa.design.patterns.creational.abstract_factory;

public class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("Rendering Windows Button");
    }
}
