package com.company.genericsAndBounds;

import java.util.*;

public class GenericsAndBounds {

    public static<T> void printList(List<T> list){
        if (list==null){
            return;
        }
        System.out.println(list);
    }

    public static<T> List<T> listConverter(T[] arr){
        return Arrays.asList(arr);
    }

    public static<T> T maxElement(List<T> list, Comparator<T> comparator){
        list.sort(comparator);
        return list.get(list.size()-1);
    }

    public static<T> void copy(List<T> dest,List<? extends T> src){
        dest.addAll(src);
    }

}
