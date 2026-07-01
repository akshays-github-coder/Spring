// Step 4: Concrete Factories

package com.cwa.design.patterns.creational.abstract_factory;

public class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextBox createTextBox() {
        return new MacTextBox();
    }
}
