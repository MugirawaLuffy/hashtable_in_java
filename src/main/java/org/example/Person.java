package org.example;

public class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age; this.name = name;
    }

    @Override
    public String toString() {
        return "Name=" + this.name + ", Age=" + this.age;
    }
}
