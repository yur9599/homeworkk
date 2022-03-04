package com.company.homework7.task4.square;

import com.company.homework7.task4.shape.Shape;

public class Square implements Shape {

    private int side;

    public Square(int side){
        this.side=side;
    }

    @Override
    public double area() {
        return Math.pow(side,2);
    }

    @Override
    public double perimeter() {
        return 4*side;
    }

}
