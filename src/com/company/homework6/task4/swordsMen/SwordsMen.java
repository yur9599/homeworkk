package com.company.homework6.task4.swordsMen;

import com.company.homework6.task4.warrior.Warrior;

public class SwordsMen extends Warrior {

    public SwordsMen(){
        name="Isn`t defined";
        type="Isn`t defined";
        health=0;
        power=0;
    }

    public SwordsMen(String name,String type,double power,double health){
        this.name=name;
        this.type=type;
        this.power=power;
        this.health=health;
    }

    @Override
    public void hit(){
        System.out.println("Hits by sword");
    }

    @Override
    public String toString() {
        return "SwordsMen{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", power=" + power +
                ", health=" + health +
                '}';
    }

}
