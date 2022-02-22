package com.company.homework1;


public class Strings {

    public static int realLength(String word){
        return word.length();
    }

    public static char neededChar(int index,String word){
        return word.charAt(index);
    }

    public static boolean cont(String word,char ch){
        char[] arr=word.toCharArray();
        for (int i=0;i < arr.length;i++) {
            if (arr[i]==ch)
                return true;
        }
        return false;
    }

    public static int vowelCounter(String word){
        char[] arr=word.toCharArray();
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u'){
                count++;
            }
            if (arr[i]=='A' || arr[i]=='E' || arr[i]=='I' || arr[i]=='O' || arr[i]=='U'){
                count++;
            }
        }
        return count;
    }

    public static void rev(String word){
        char[] arr=word.toCharArray();
        for (int i = arr.length-1; i >=0; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void countVowelsDigits(String word){
        char[] arr=word.toCharArray();
        double count=vowelCounter(word);
        double secCount=0;
        for (int i=0;i<word.length();i++){
                if (arr[i]>='0' && arr[i]<='9')
                    secCount++;
        }
        double d=(count*100)/word.length();
        double c=(secCount*100)/word.length();
        System.out.println(count+" "+d+"\n");
        System.out.println(secCount+" "+c);
    }

    public static String  caesar(String word){
        char[] arr=word.toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<arr.length;i++){
            if (arr[i]>='A' && arr[i]<='W'){
                arr[i]+=3;
                sb.append(arr[i]);
            }
            if (arr[i]=='X')
                sb.append('A');
            if (arr[i]=='Y')
                sb.append('B');
            if (arr[i]=='Z')
                sb.append('C');
        }
        String caesarWord= sb.toString();
        return caesarWord;
    }

    public static boolean isPalindrom(String word){
        char[] arr=word.toCharArray();
        int length=arr.length-1;
        int count=0;
        for (int i = 0; i < word.length(); i++) {
            if (arr[i]==arr[length]){
                count++;
            }
            length--;
        }
        if (count==arr.length)
            return true;
        return false;
    }

    public static boolean isBinary(String word){
        char[] arr=word.toCharArray();
        int count=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]=='1' || arr[i]=='0'){
                count++;
            }
        }
        if (count==arr.length)
            return true;
        return false;
    }

    public static boolean isHex(String word){
        char[] arr=word.toCharArray();
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>='a' && arr[i]<='f'){
                count++;
            }
            else if (arr[i]>='A' && arr[i]<='F'){
                count++;
            }
            else if (arr[i]>='0' && arr[i]<='9'){
                count++;
            }
        }
        if (count==arr.length)
            return true;
        return false;
    }

    public static int bin2Dec(String word){
        char[] arr=word.toCharArray();
        int realIndex=arr.length-1;
        int dec=0;
        if (isBinary(word)) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '1') {
                    dec += 1 * Math.pow(2, realIndex);
                    realIndex--;
                } else {
                    dec += 0;
                    realIndex--;
                }
            }
        }
        return dec;
    }

    public static int dupCounter(String word){
        char[] arr=word.toCharArray();
        int count=0;
        int realDup=0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]==arr[j]){
                    count++;
                }
            }
            if (count==1){
                realDup++;
            }
            count=0;
        }
        return realDup;
    }

    public static char firtNotRepeated(String word){
        char[] arr=word.toCharArray();
        int count=0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]==arr[j]){
                    count++;
                }
            }
            if (count==0){
                return arr[i];
            }
            count=0;
        }
        return '0';
    }

    public static int repetedChar(String word,char ch){
        char[] arr=word.toCharArray();
        int count=0;
        for (int i=0;i<arr.length;i++){
            if (ch==arr[i])
                count++;
        }
        return count;
    }

}
