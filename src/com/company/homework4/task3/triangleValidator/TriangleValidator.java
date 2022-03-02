package com.company.homework4.task3.triangleValidator;

import com.company.homework4.task3.triangle.Triangle;

public class TriangleValidator {

    private TriangleValidator(){}

    public static boolean isValidSide(int side) {
        return  (side>=1) && (side<=20) ;
    }

    private static boolean isValidTriangle(int side1,int side2,int side3) {
        return  (side1+side2)>side3;
    }

    public static boolean check(Triangle triangle){
        if (triangle.getSideA()>triangle.getSideB() && triangle.getSideA()>triangle.getSideC()) {
            return isValidTriangle(triangle.getSideB(), triangle.getSideC(), triangle.getSideA());
        }
        else if (triangle.getSideB()>triangle.getSideA() && triangle.getSideB()>triangle.getSideC()){
            return isValidTriangle(triangle.getSideA(), triangle.getSideC(), triangle.getSideB());
        }
        else {
            return isValidTriangle(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
        }
    }

    public static boolean isTriangleRight(int side1,int side2,int side3) {
        if (Math.pow(side1,2)+Math.pow(side2,2)==Math.pow(side3,2)){
            return true;
        }
        if (Math.pow(side1,2)+Math.pow(side3,2)==Math.pow(side2,2)){
            return true;
        }
        return Math.pow(side2, 2) + Math.pow(side3, 2) == Math.pow(side1, 2);
    }

    private static void perimeterOrSquare(int side1,int side2) {
        System.out.println("Square="+(double)(side1*side2)/2);
    }

    private static void perimeterOrSquare(int side1,int side2,int side3) {
        System.out.println("Perimeter="+(side1+side2+side3));
    }

    public static void uniCounter(int side1,int side2,int side3){
        if (side1>side2 && side1>side3){
            if (isTriangleRight(side2,side3,side1)){
                perimeterOrSquare(side2,side3);
                return;
            }
        }
        else if (side2>side1 && side2>side3) {
            if (isTriangleRight(side1, side3, side2)) {
                perimeterOrSquare(side1, side3);
                return;
            }
        }
        else if (side3>side1 && side3>side2){
            if (isTriangleRight(side1,side2,side3)){
                perimeterOrSquare(side1,side2);
                return;
            }
        }
        perimeterOrSquare(side1,side2,side3);
    }

}
