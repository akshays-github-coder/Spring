package com.cwa.design.patterns.creational.builder;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Employee {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
/*

    public Employee(EmployeeBuilder builder) {

        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
    }
*/
}