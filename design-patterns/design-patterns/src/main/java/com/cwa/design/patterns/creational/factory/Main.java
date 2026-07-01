/*
Factory Pattern :-
Provides an interface for creating objects without exposing the object creation logic to the client.

The client asks the factory for an object instead of creating it directly.

-------------------------------------------------------------------------------------------

Class Diagram

                Payment
                    ^
                    |
       -------------------------
       |           |           |
   UPI       CreditCard   NetBanking

                    ^
                    |
             PaymentFactory
                    |
                Client

Where Factory Pattern Is Used in Spring?

Spring itself heavily uses Factory Pattern.

Examples:

BeanFactory → Creates beans
ApplicationContext → Creates and manages beans
FactoryBean<T> → Custom bean creation
Hibernate SessionFactory
LoggerFactory in SLF4J

Examples:

Spring Framework BeanFactory
Spring Framework ApplicationContext
Hibernate SessionFactory
SLF4J LoggerFactory

--------------------------------------------------------------------------------------------

Advantages
1. Loose Coupling

Instead of:

        new UPIPayment()

Use:

        PaymentFactory.getPayment()

2. Centralized Object Creation
All creation logic is in one place.

3. Easier Maintenance
Client code remains unchanged.

4. Supports Open/Closed Principle
New implementations can be added easily.

5. Better Testing
Payment payment = mock(Payment.class);

Can easily replace implementations.

------------------------------------------------------------------------------------------

Comparison: Factory vs Abstract Factory

| Feature          | Factory             | Abstract Factory                                                               |
| ---------------- | ------------------- | ------------------------------------------------------------------------------ |
| Purpose          | Creates one product | Creates families of related products                                           |
| Complexity       | Simple              | More complex                                                                   |
| Classes involved | Product + Factory   | Product interfaces + Concrete products + Abstract factory + Concrete factories |
| Example          | `PaymentFactory`    | `GUIFactory` (WindowsFactory, MacFactory)                                      |

-----------------------------------------------------------------------------------------

Interview Answer (2 Minutes)

Factory Pattern is a creational design pattern that encapsulates object creation logic and hides implementation details from the client.
Instead of creating objects using new, the client requests them from a factory.
This promotes loose coupling, improves maintainability, and follows dependency inversion principles.
In Java, examples include Calendar.getInstance(), LoggerFactory, and in Spring, BeanFactory and ApplicationContext.
A common use case is selecting different implementations such as UPI, Credit Card, or Net Banking payment services based on runtime input.
*/


package com.cwa.design.patterns.creational.factory;

public class Main {

    public static void main(String[] args) {

        Payment payment =
                PaymentFactory.getPayment("UPI");

        payment.pay(1000);
    }
}
