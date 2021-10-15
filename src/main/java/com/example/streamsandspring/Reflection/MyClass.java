package com.example.streamsandspring.Reflection;

@Author(name = "Kirill", dateOfCreation = 2021)
public class MyClass {

    private String name;
    private int age;

    public MyClass() {
        this.name = "Mike";
        this.age = 29;
    }

    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
