package com.company.homework6.task4.shooter;

import com.company.homework6.task4.warrior.Warrior;

public class Shooter extends Warrior {

    public Shooter(){
        name="Isn`t defined";
        type="Isn`t defined";
        health=0;
        power=0;
    }

    public Shooter(String name,String type,double power,double health){
        this.name=name;
        this.type=type;
        this.power=power;
        this.health=health;
    }

    @Override
    public void hit(){
        System.out.println("Hits by weapon");
    }

    @Override
    public String toString() {
        return "Shooter{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", power=" + power +
                ", health=" + health +
                '}';
    }

}
