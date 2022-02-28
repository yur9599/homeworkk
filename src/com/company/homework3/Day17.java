package com.company.homework3;

public class Day17 {

    public static void add(int a,int b) {
        System.out.println("Pure method");
    }
    public static void add(int a,int b,int c) {
        System.out.println("Overloaded by parameter increaser");
    }
    public static void add(int a,float b) {
        System.out.println("Overloaded by parameter type");
    }
    public static void add(float a,int b) {
        System.out.println("Overloaded by parameter reverse");
    }


    public static int fun(int a) {
        return a;
    }
    public static float fun(float a) {
        return a;
    }


    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i!=arr.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    public static void print(float[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i!=arr.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    public static void print(double[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i!=arr.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }


    public static int search(int[] arr) {
        return arr.length;
    }
    public static int search(int[] arr,int a) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==a){
                return i;
            }
        }
        return -1;
    }
    public static boolean search(int[] arr,int a,int index) {
        if (arr[index]==a){
            return true;
        }
        return false;
    }


    public static double square(int a) {
        return 3.14*(a*a);
    }
    public static float square(float a) {
        return (a*a);
    }
    public static int square(int a,int b) {
        return a*b;
    }


    public static int max(int a,int b) {
        return (a>b)? a:b;
    }
    public static int max(int a,int b,int c) {
        int max=max(a,b);
        return (max>c)? max:c;
    }
    public static int max(int a,int b,int c,int d) {
        int max=max(a,b,c);
        return (max>d)? max:d;
    }


    public static double distance(int x,int y) {
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
    public static double distance(int x1,int y1,int x2,int y2) {
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }


    public static void fahrenheitCelsius(float celsius,int choice) {
        if (choice==1){
            System.out.println((int)celsius+" celsius is "+(celsius*(9/5)+32)+" fahrenheit");
        }
        else if (choice==2){
            System.out.println((double)celsius+" celsius is "+(celsius*(9/5)+32)+" fahrenheit");
        }
        else {
            System.out.println("Illegal argument given! ");
        }
    }
    public static void fahrenheitCelsius(int choice,float fahrenheit) {
        if (choice==1){
            System.out.println((int)fahrenheit+" fahrenheit is "+((fahrenheit-32)*5/9)+" celsius");
        }
        else if (choice==2){
            System.out.println((double)fahrenheit+" fahrenheit is "+((fahrenheit-32)*5/9)+" celsius");
        }
        else {
            System.out.println("Illegal argument given! ");
        }
    }

    public static int reminder(int value) {
        int sum=0;
        while (value>0){
            sum+=value%10;
            value/=10;
        }
        return sum;
    }
    public static int reminder(int value,int natural) {
        if (natural<1){
            System.out.print("The number isn`t natural ");
            return natural;
        }
        return reminder(value)%natural ;
    }

}
