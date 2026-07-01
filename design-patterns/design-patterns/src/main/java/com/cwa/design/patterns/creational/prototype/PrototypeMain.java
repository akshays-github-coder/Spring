/*
Definition

Prototype Pattern creates new objects by cloning an existing object instead of instantiating a new one.

Instead of:

Employee emp = new Employee();

We do:

Employee emp2 = emp1.clone();

---------------------------------------------------------------------------------------

Why Do We Need It?

Imagine:

Employee employee = new Employee();

Object creation involves:

- Database calls
- API calls
- Expensive calculations
- Large object graph initialization

Creating the object repeatedly is expensive.

Instead:

Employee copy = employee.clone();

Much faster.
*/

package com.cwa.design.patterns.creational.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PrototypeMain {
    public static void main(String[] args) {

        // Start Spring Container
        ApplicationContext context =
                SpringApplication.run(
                        PrototypeMain.class, args);

        // Spring creates Student Object #1
        Student s1 = context.getBean(Student.class);

        // Spring creates Student Object #2
        Student s2 = context.getBean(Student.class);

        // Print memory addresses
        System.out.println("Student 1 : " + s1);
        System.out.println("Student 2 : " + s2);

        // Compare both references
        System.out.println("Are both same object? "
                + (s1 == s2));
    }
}
