package com.company.recursions;


public class Recursion {

    private Recursion(){}

    public static int fac(int n){
        if (n<0){
            return -1;
        }
        if (n==1){
            return 1;
        }
        return n*fac(n-1);
    }

    public static int sumOfGivenArr(int[] arr){
        if (arr.length==1){
            return arr[0];
        }
        int[] array = new int[arr.length-1];
        System.arraycopy(arr, 0, array, 0, array.length);
        return arr[arr.length-1]+sumOfGivenArr(array);
    }

    public static int fib(int n){
        if (n<0){
            return -1;
        }
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    public static boolean isPalindrome(String word){
        if (word==null){
            return false;
        }
        return palindromeHelper(word);
    }

    private static boolean palindromeHelper(String word){
        char[] chars = word.toCharArray();
        if (chars[0]==chars[chars.length-1]){
            if (word.length()==3 || word.length()==2){
                return true;
            }
            String word1=word.substring(1,word.length()-1);
            return palindromeHelper(word1);
        }
        return false;
    }

    public static int triangle(int n){
        if (n==0){
            return 0;
        }
        return n+triangle(n-1);
    }

    public static int sumOfDigits(int n){
        if (n==0){
            return 0;
        }
        return 1+sumOfDigits(n/10);
    }

    public static int countOf7digits(int n){
        if (n==0){
            return 0;
        }
        return ((n%10==7)? 1:0)+countOf7digits(n/10);
    }

    public static int numOfLowerCases(String word){
        if (word.length()==0){
            return 0;
        }
        return ((word.charAt(word.length()-1)=='x')? 1:0) + numOfLowerCases(word.substring(0,word.length()-1));
    }

    public static String wordWithoutX(String word){
        if (word.length()==0){
            return "";
        }
        return ((word.charAt(word.length()-1)!='x')? (word.charAt(word.length()-1)):"") + wordWithoutX(word.substring(0,word.length()-1));
    }

    public static String reverseString(String word){
        if (word.length()==0){
            return "";
        }
        return (word.charAt(word.length()-1)) + reverseString(word.substring(0,word.length()-1));
    }

    public static String endX(String word){
        if (word.length()==0){
            return "";
        }
        return (word.charAt(0)!='x') ? word.charAt(0)+endX(word.substring(1)) : endX(word.substring(1))+word.charAt(0);
    }

    public static String stringClean(String word){
        if (word.length()==1){
            return word;
        }
        return (word.charAt(0)!=word.charAt(1)) ? word.charAt(0) + stringClean(word.substring(1)):stringClean(word.substring(1));
    }

    public static boolean isPrime(int n){
        if (n<=1){
            return false;
        }
        return isPrimeHelper(n,n/2);
    }

    private static boolean isPrimeHelper(int n,int changeable){
        if (changeable==1){
            return true;
        }
        return n % changeable != 0 && isPrimeHelper(n, changeable - 1);
    }

    public static char largestDigit(String chars){
        if (chars.length()==1){
            return 0;
        }
        return (chars.charAt(0)>chars.charAt(1)) ?
                (chars.charAt(0)>largestDigit(chars.substring(1))) ?
                        chars.charAt(0) :
                largestDigit(chars.substring(1)) :
                (chars.charAt(1)>largestDigit(chars.substring(1))) ?
                        chars.charAt(1) :
                largestDigit(chars.substring(1));
    }

    public static int numberOfDigits(String chars){
        if (chars.length()==0){
            return 0;
        }
        return ((chars.charAt(0)>='0' && chars.charAt(0)<='9')? 1:0)+numberOfDigits(chars.substring(1));
    }

    public static String asteriskLetters(String word){
        if (word.length()==0){
            return "";
        }
        return word.charAt(0) + ((word.length()==1)? "":"*") +asteriskLetters(word.substring(1));
    }

    public static String charactersInTheBrackets(String word){
        if (word==null){
            return "!";
        }
      return (word.length()%2==0) ? charactersInTheBracketsForEven(word) : charactersInTheBracketsForOdd(word);
    }

    private static String charactersInTheBracketsForOdd(String word){
        if (word.length()==1){
            return "("+word+")";
        }
        return "(" + word.charAt(0) + charactersInTheBracketsForOdd(word.substring(1,word.length()-1)) +
                word.charAt(word.length()-1) + ")";
    }

    private static String charactersInTheBracketsForEven(String word){
        if (word.length()==2){
            return "("+word+")";
        }
        return "(" + word.charAt(0) + charactersInTheBracketsForEven(word.substring(1,word.length()-1)) +
                word.charAt(word.length()-1) + ")";
    }

    public static String mirroredString(String word){
        if (word.length()==0){
            return "";
        }
        System.out.print(word.charAt(0));
        return (word.charAt(0)=='(') ? mirroredString(word.substring(1)) + ")" :
                mirroredString(word.substring(1)) + word.charAt(0) ;
    }

    public static String identicalLettersCutter(String word){
        if (word.length()==1){
            return word;
        }
        else if (word.length()==0){
            return "";
        }
        return (word.charAt(0)==word.charAt(word.length()-1)) ?
                identicalLettersCutter(word.substring(1,word.length()-1)) :
                word.charAt(0) + identicalLettersCutter(word.substring(1,word.length()-1)) +
                        word.charAt(word.length()-1);
    }

}
