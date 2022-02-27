package com.company.homework2;

public class Day16 {

    public static void calculatePow(){
        int var=1;
        for (int n=0;n<=15;n++){
            System.out.println(var<<n);
        }
    }

    public static void timeDeterminer(int n) {
        if (n<0){
            return;
        }
        System.out.println((n / 60)%24+" "+n % 60);
    }

    /**
     * 5.
     * 1st-14 times:
     * 2nd-12 times:
     * 3rd-22 times:
     */

    public static boolean isPrime(int n) {
        if (n<=1){
            return false;
        }
        for (int i = 2; i <= n/2; i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void palindromNum(int a,int b) {
        if (a==b && (b-a)<110){
            return ;
        }
        if (a>1000 && a<9999 && b>1000 && b<9999){
            int y=0;
            int z=0;
            for (int i=a;i<=a+110;i++) {
                int x=i;
                while (x > 0) {
                    z = x % 10;
                    y = y * 10 + z;
                    x = x / 10;
                }
                if (y==i){
                    while (y<=b){
                        System.out.println(y);
                        if ((y % 1000 / 10) == 99){
                            y+=11;
                            System.out.println(y);
                        }
                        y+=110;
                    }
                    break;
                }
                y=0;
            }
        }
    }

    public static String  firstUpperCase(String word) {
        if (word.length()>3){
            return "Don`t do that ";
        }
        word=word.toLowerCase();
        char ch=word.charAt(0);
        return word.replace(ch, (char) (ch-32));
    }

    public static void oAndXs(int n) {
        char[][] ch=new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i+j)%2==0){
                    ch[i][j]='O';
                }
                else{
                    ch[i][j]='O';
                }
                System.out.print(ch[i][j]);
            }
            System.out.println();
        }
    }

    public static double nthGeometricalpeogresson(double num,double q,double n) {
        for (int i=1;i<n;i++){
            num*=q;
        }
        return num;
    }

    public static void expendIntoPrimes(int n) {
        StringBuilder sb = new StringBuilder();
        int num=n;
        for (int i = 2; i <= num / 2; i++) {
            while (num%i==0){
                sb.append(i).append('*');
                num/=i;
            }
        }
        if (num!=1){
            System.out.println(sb.append(num));
        }
        else {
            System.out.println(sb.substring(0,sb.length()-1));
        }
    }

    public static void twoDimArrWOneLoop(int n,int m) {
        int[][] arr = new int[n][m];
        int row;
        int col;
        for (int i=0;i<n*m;i++){
            row=i/m;
            col=i%m;
            System.out.print(arr[row][col]=col*row);
            if (col==2){
                System.out.println();
            }
        }
    }

    public static int[][] diagonalTwoDimArr(int[][] arr) {
        int increaser=0;
        int length=arr.length+arr[0].length-1;
        for (int j = 0; j < length; j++) {
            int i=0;
            int var=j;
            if (j>=arr[0].length){
                i=j-arr[0].length+1;
                var=arr[0].length-1;
                while (i < arr.length){
                    arr[i][var]=increaser;
                    increaser++;
                    i++;
                    var--;
                }
            }
            else {
                while (i < arr.length && var < arr[0].length && var >= 0) {
                    arr[i][var] = increaser;
                    increaser++;
                    i++;
                    var--;
                }
            }
        }
        return arr;
    }

    public static int[][] snakeTwoDimArr(int arr[][]) {
        int increaser=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i%2==0) {
                    arr[i][j] = increaser;
                }
                else {
                    arr[i][arr[0].length-j-1]=increaser;
                }
                increaser++;
            }
        }
        return arr;
    }

    public static int[][] turnMatrixIn90degree(int[][] arr) {
        int x=arr.length;
        int last=x-1;
        int firstElem=0;
        for (int i = 0; i < x/2; i++) {
            for (int j = i; j <last-i ; j++) {
                firstElem=arr[i][j];
                arr[i][j]=arr[last-j][i];
                arr[last-j][i]=arr[last-i][last-j];
                arr[last-i][last-j]=arr[j][last-i];
                arr[j][last-i]=firstElem;
            }
        }
        return arr;
    }

    public static int[][] turnMatrixIn180degree(int[][] arr) {
        int x=arr.length;
        int last=x-1;
        int[][] array=new int[x][x];
        for (int i = last; i >= 0; i--) {
            for (int j = last; j >= 0; j--) {
                array[i][j]=arr[last-i][last-j];
            }
        }
        return array;
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
