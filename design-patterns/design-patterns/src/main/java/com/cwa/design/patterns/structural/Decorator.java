package com.cwa.design.patterns.structural;

public class Decorator {

/*

Definition

Decorator Pattern allows behavior or responsibilities to be added to an object dynamically without modifying its existing code.

-----------------------------------------------------------------------------------------

Real-Life Example

Pizza: Base Pizza
Add: Cheese
Add: Olives
Add: Mushrooms

Each topping decorates the pizza.

----------------------------------------------------------------------------------------

    Java Example from JDK

    One of the best examples:

    InputStream inputStream =
            new FileInputStream("test.txt");

    inputStream =
            new BufferedInputStream(
            inputStream);

    inputStream =
            new DataInputStream(
            inputStream);

    Object Structure:

    DataInputStream
       |
    BufferedInputStream
       |
    FileInputStream

    This is Decorator Pattern.
    */
}
