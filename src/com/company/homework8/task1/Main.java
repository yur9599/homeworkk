package com.company.homework8.task1;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(input());
    }

    public static int input(){
        Scanner sc=new Scanner(System.in);
        String num;
        int number=0;
        while (true){
            System.out.print("Input num ");
            num= sc.nextLine();
            try{
                number=Integer.parseInt(num);
                return number;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid number ");
            }
        }
    }

}
