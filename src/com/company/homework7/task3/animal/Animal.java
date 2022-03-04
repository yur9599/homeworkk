package com.company.homework7.task3.animal;

public class Animal {

    protected int age;
    protected String  name;

    public Animal(int age,String name){
        this.age=age;
        this.name=name;
    }

    public Animal(){
        this.name="Isn`t defined";
    }

    public void sound(){
        System.out.println("Animal is making sound");
    }

}
