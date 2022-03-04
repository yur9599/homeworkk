package com.company.homework7.task4;

import com.company.homework7.task4.circle.Circle;
import com.company.homework7.task4.rectangle.Rectangle;
import com.company.homework7.task4.shape.Shape;
import com.company.homework7.task4.square.Square;

public class Main {

    public static void main(String[] args) {
        Square square = new Square(4);
        Rectangle rectangle = new Rectangle(4,2);
        Circle circle = new Circle(4);
        Shape[] shapes={square,rectangle,circle};
        for (Shape x:shapes){
            System.out.println(x.area()+"   "+ x.perimeter());
        }
    }

}
