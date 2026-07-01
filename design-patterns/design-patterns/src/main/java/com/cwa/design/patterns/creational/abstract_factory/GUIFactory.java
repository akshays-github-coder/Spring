// Step 3: Abstract Factory Interface

package com.cwa.design.patterns.creational.abstract_factory;

public interface GUIFactory {

    Button createButton();
    TextBox createTextBox();
}