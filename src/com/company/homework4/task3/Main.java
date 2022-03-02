package com.company.homework4.task3;

import com.company.homework4.task3.triangle.Triangle;
import static com.company.homework4.task3.triangleValidator.TriangleValidator.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sideA;
        int sideB;
        int sideC;

        while (true){
            System.out.print("SideA = ");
            sideA=sc.nextInt();
            System.out.print("SideB = ");
            sideB=sc.nextInt();
            System.out.print("SideC = ");
            sideC=sc.nextInt();
            if (isValidSide(sideA) && isValidSide(sideB) && isValidSide(sideC)) {
                break;
            }
            else {
                System.out.println("Invalid size");
            }
        }

        Triangle tr=new Triangle(sideA,sideB,sideC);
        if (check(tr)){
            isTriangleRight(sideA,sideB,sideC);
            uniCounter(sideA,sideB,sideC);
        }
    }

}
