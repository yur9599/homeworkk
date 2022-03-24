package com.company.homework10;

import java.util.*;

public class Methods {

    public static boolean duplicateCheck(Integer[] arr){
        Set<Integer> set = new HashSet<>();
        for (Integer integer : arr) {
            if (!(set.add(integer))) {
                return true;
            }
        }
        return false;
    }

    public static void uniqueElem(Integer[] arr){
        int i=0;
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer integer : arr) {
            map.put(integer,i);
        }
        for (Integer integer : arr) {
            if (map.containsKey(integer)){
                map.put(integer, (map.get(integer)+1));
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer)==1){
                System.out.print(integer+" ");
            }
        }
    }

    public static int countDubChars(String chars){
        int i=0;
        int count=0;
        char[] character = chars.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (Character integer : character) {
            map.put(integer,i);
        }
        for (Character integer : character) {
            if (map.containsKey(integer)){
                map.put(integer, (map.get(integer)+1));
            }
        }
        for (Character integer : map.keySet()) {
            if (map.get(integer)>1){
                count++;
            }
        }
        return count;
    }

    public static char firstNonRepChar(String chars){
        int i=0;
        char[] character = chars.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (Character integer : character) {
            map.put(integer,i);
        }
        for (Character integer : character) {
            if (map.containsKey(integer)){
                map.put(integer, (map.get(integer)+1));
            }
        }
        for (Character integer : map.keySet()) {
            if (map.get(integer)==1){
                return integer;
            }
        }
        return ' ';
    }

    public static int sizeOfLongestSubstring(String chars){
        int start=0;
        int maxLength=0;
        char[] character = chars.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int k=0;k< character.length;k++) {
            if (map.containsKey(character[k])) {
                start=Math.max(start,map.get(character[k])+1);
            }
            map.put(character[k],k);
            maxLength=Math.max(maxLength,k-start+1);
        }
        return maxLength;
    }

}
