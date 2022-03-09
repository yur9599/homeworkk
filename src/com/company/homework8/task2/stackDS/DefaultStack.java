package com.company.homework8.task2.stackDS;

import com.company.homework8.task2.customExceptions.EmptyStackException;
import com.company.homework8.task2.customExceptions.StackIndexOutOfBoundsException;

public class DefaultStack implements StackInterface{

    private final int[] nums;
    private int index;
    private static final int MAX_SIZE=5;

    public DefaultStack(){
        nums=new int[MAX_SIZE];
        index=-1;
    }


    @Override
    public int pop(){
        if (index<0){
            throw new EmptyStackException();
        }
        int deletedNum=nums[index--];
        return deletedNum;
    }

    @Override
    public void push(int value){
        if (index==MAX_SIZE-1){
            throw new StackIndexOutOfBoundsException();
        }
        nums[++index]=value;
    }

    public void printStack(){
        System.out.print("[");
        for (int i=0;i<=index;i++) {
            System.out.print(nums[i]);
            if (i==index){
                break;
            }
            System.out.print(",");
        }
        System.out.print("]");
    }

}
