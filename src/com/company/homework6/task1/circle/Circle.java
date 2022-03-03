package com.company.homework6.task1.circle;

import com.company.homework6.task1.shape.Shape;

public class Circle extends Shape {

    private double radius;

    public Circle(){}

    public Circle(double radius){
        super(radius);
        this.radius=super.radius;
    }

    @Override
    public double getArea(){
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

}
