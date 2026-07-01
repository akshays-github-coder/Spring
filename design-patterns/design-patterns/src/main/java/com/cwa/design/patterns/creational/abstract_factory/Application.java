// Step 5: Client Code

package com.cwa.design.patterns.creational.abstract_factory;

public class Application {

    private Button button;
    private TextBox textBox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        textBox = factory.createTextBox();
    }

    public void renderUI() {
        button.paint();
        textBox.render();
    }
}