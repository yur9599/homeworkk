package com.company.homework9;

public interface List extends Iterable<Integer> {

    int size();

    boolean isEmpty();

    int get(int index);

    void add(int val);

    void add(int index, int val);

    int delete(int index);

}
