package com.company.homework6.task1.shape;

public abstract class Shape {

    protected double radius;
    protected double side;

    public Shape(){}

    public Shape(int side){
        this.side=side;
    }

    public Shape(double radius){
        this.radius=radius;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

}
