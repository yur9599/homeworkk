package com.company.homework7.task3.cat;

import com.company.homework7.task3.animal.Animal;

public class Cat extends Animal {

    protected int age;
    protected String name;

    public Cat(int age, String name) {
        this.age=age;
        this.name=name;
    }

    @Override
    public void sound() {
        System.out.println("Myau-myau");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
