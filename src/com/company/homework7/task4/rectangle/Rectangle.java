package com.company.homework7.task4.rectangle;

import com.company.homework7.task4.shape.Shape;

public class Rectangle implements Shape {

    private int length;
    private int width;

    public Rectangle(int length,int width){
        this.length=length;
        this.width=width;
    }

    @Override
    public double area() {
        return length*width;
    }

    @Override
    public double perimeter() {
        return 2*(length+width);
    }

}
