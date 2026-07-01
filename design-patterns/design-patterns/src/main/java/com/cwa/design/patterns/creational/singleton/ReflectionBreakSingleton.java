// Ways to break Singleton:
//
//        1. Reflection
//        2. Serialization/Deserialization
//        3. Cloning
//        4. Multiple Class Loaders
//
// Ways to protect Singleton:
//
//        1. Constructor guard (partial protection)
//        2. readResolve() for serialization
//        3. Override clone()
//        4. Use Enum Singleton (best and safest approach)

package com.cwa.design.patterns.creational.singleton;

import java.lang.reflect.Constructor;

public class ReflectionBreakSingleton {

    public static void main(String[] args) throws Exception {

        // Normal Singleton object creation
        Singleton singleton1 = Singleton.getInstance();

        /*
         * Reflection API allows access to class metadata.
         * Here we fetch the private constructor.
         */
        Constructor<Singleton> constructor =
                Singleton.class.getDeclaredConstructor();

        /*
         * By default private constructor cannot be accessed.
         * setAccessible(true) bypasses Java access modifiers.
         */
        constructor.setAccessible(true);

        /*
         * Creates a NEW object even though constructor is private.
         * This breaks Singleton principle.
         */
        Singleton singleton2 = constructor.newInstance();

        // Print memory identities
        System.out.println("Singleton 1 HashCode: "
                + singleton1.hashCode());

        System.out.println("Singleton 2 HashCode: "
                + singleton2.hashCode());

        /*
         * Comparing references.
         * Singleton should have only one object.
         * But reflection created another one.
         */
        System.out.println("Are both objects same? "
                + (singleton1 == singleton2));
    }
}