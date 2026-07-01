/*

Builder Pattern Definition

Builder Pattern constructs complex objects step-by-step and allows creation of immutable objects with readable code.

-----------------------------------------------------------------------------------------

Why Do We Need Builder Pattern?

Suppose you have an Employee class:

public class Employee {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String address;
    }

----------------------------------------------------------------------------------------

Problem 1: Too Many Constructor Parameters

Employee emp = new Employee(
        "Akshay",
        "Sarambale",
        30,
        "abc@gmail.com",
        "9999999999",
        "Mumbai");

Problems:

Difficult to remember parameter order
Easy to make mistakes
Poor readability

----------------------------------------------------------------------------------------

Problem 2: Telescoping Constructors

public Employee(String firstName) {}
public Employee(
        String firstName,
        String lastName) {}

public Employee(
        String firstName,
        String lastName,
        int age) {}

Soon you'll have dozens of constructors.

-------------------------------------------------------------------------------------

Problem 3: Setters

Employee emp = new Employee();

emp.setFirstName("Akshay");
emp.setLastName("Sarambale");
emp.setAge(30);

Problems:

Object is mutable
Object may be incomplete
Thread safety issues

---------------------------------------------------------------------------------------

Output Structure

EmployeeBuilder
     |
     | build()
     v
 Employee Object

 ---------------------------------------------------------------------------------

 Why return this?

public EmployeeBuilder age(int age) {
    this.age = age;
    return this;
}

Allows method chaining:

builder
  .firstName("Akshay")
  .lastName("Sarambale")
  .age(30)

  This is called a Fluent API.

----------------------------------------------------------------------------------------

Builder Pattern with Validation

Builder can validate before object creation.

public Employee build() {
    if(firstName == null) {
        throw new IllegalArgumentException(
                "First name required");
    }
    return new Employee(this);
}

Very common in enterprise applications.

---------------------------------------------------------------------------------------

Lombok Builder

In Spring Boot projects this is the most common approach.

Add dependency:

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>

-----------------------------------------------------------------------------------------

Class

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Employee {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
}

-------------------------------------------------------------------------------------

Usage

Employee employee =
        Employee.builder()
                .firstName("Akshay")
                .lastName("Sarambale")
                .age(30)
                .email("abc@gmail.com")
                .build();

Lombok generates the builder automatically.

*/

package com.cwa.design.patterns.creational.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {

        Employee employee =
                Employee.builder()
                        .firstName("Akshay")
                        .lastName("Sarambale")
                        .age(30)
                        .email("abc@gmail.com")
                        .build();

        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getAge());
        System.out.println(employee.getEmail());
    }
}
