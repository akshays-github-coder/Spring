/*
Definition:

Abstract Factory provides an interface to create families of related or dependent objects without specifying their concrete classes.

----------------------------------------------------------------------------------------

Real-Life Example

Think of UI elements:

Windows UI: WindowsButton, WindowsTextBox
Mac UI: MacButton, MacTextBox

You want a UI library that creates elements according to the OS without the client knowing the concrete classes.

Family 1: Windows
Button, TextBox

Family 2: Mac
Button, TextBox

This is exactly what Abstract Factory does.

AbstractFactory
       ^
       |
   ----------------
   |              |
WinFactory       MacFactory
   |              |
   v              v
Button, TextBox   Button, TextBox

---------------------------------------------------------------

Key Points
1. Abstract Factory = Factory of Factories
Each factory creates a family of related objects.

2. Promotes Consistency
All UI components belong to the same family (Windows/Mac).

3. Open/Closed Principle
Adding a new family (LinuxFactory) does not require changing existing factories.

4.Separation of Concerns
Client only interacts with abstract factory and product interfaces.*/

// Step 6: Usage

package com.cwa.design.patterns.creational.abstract_factory;

public class Main {
    public static void main(String[] args) {

        String os = "Windows"; // This could come from config

        GUIFactory factory;

        if (os.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Application app = new Application(factory);
        app.renderUI();
    }
}