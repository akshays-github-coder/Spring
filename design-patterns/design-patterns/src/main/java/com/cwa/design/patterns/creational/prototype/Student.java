package com.cwa.design.patterns.creational.prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component              // Register bean in Spring container
@Scope("prototype")    // Create a NEW object every time getBean() is called
public class Student {

    public Student() {
        System.out.println("Student Object Created");
    }
}