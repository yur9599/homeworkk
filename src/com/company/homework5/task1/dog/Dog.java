package com.company.homework5.task1.dog;

import com.company.homework5.task1.animal.Animal;

public class Dog extends Animal {

    @Override
    public void voice(){
        System.out.println("gaf-gaf");
    }

    @Override
    public void eat(){
        System.out.println("Dog is eating");
    }

}
