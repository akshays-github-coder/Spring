package com.cwa.design.patterns.creational.abstract_factory;

public class WindowsTextBox implements TextBox {

    @Override
    public void render() {
        System.out.println("Rendering Windows TextBox");
    }
}
