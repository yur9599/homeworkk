package com.company.homework7.task2.class2;

import com.company.homework7.task2.class1.SuperClass;

public class SubClass extends SuperClass {

    @Override
    public void classWork(int a){
        System.out.println(a+a);
    }

    @Override
    public void classWork(int a,int c){
        System.out.println(a+c);
    }

}
