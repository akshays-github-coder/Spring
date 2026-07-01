package com.cwa.design.patterns.structural;

public class Adapter {
/*
    What is Adapter Pattern?
    Definition - Adapter Pattern allows two incompatible interfaces to work together.

    Think of it as a translator between two systems.

----------------------------------------------------------------------------------------
    Java Examples
Reader and InputStream

Java provides adapters everywhere.

Example:

InputStream inputStream =
        new FileInputStream("data.txt");

Reader reader =
        new InputStreamReader(
                inputStream);

InputStreamReader adapts:

InputStream

to

Reader

------------------------------------------------------------------------------------------

Spring Examples
MVC

Spring adapts:

HTTP Request

into:

@RequestBody UserDto

using converters/adapters internally.

    */
}
