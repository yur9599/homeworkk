package com.company;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import static com.company.genericsAndBounds.GenericsAndBounds.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(6);
        list.add(18);
        list.add(9);
        list.add(7);
        System.out.println(maxElement(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }));
    }

}
