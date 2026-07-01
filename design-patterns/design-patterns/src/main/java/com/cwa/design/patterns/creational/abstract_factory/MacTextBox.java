package com.cwa.design.patterns.creational.abstract_factory;

public class MacTextBox implements TextBox {

    @Override
    public void render() {
        System.out.println("Rendering Mac TextBox");
    }
}
