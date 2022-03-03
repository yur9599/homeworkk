package com.company.homework6.task1.square;

import com.company.homework6.task1.shape.Shape;

public class Square extends Shape {

    private double side;

    public Square(){}

    public Square(int side){
        super(side);
        this.side=super.side;
    }

    @Override
    public double getArea() {
        return Math.pow(side,2);
    }

    @Override
    public double getPerimeter(){
        return 4*side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }

}
