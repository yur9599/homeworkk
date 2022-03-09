package com.company.homework8.task2.customExceptions;

public class StackIndexOutOfBoundsException extends RuntimeException{

    public StackIndexOutOfBoundsException(){
        super();
    }
    public StackIndexOutOfBoundsException(String message){
        super(message);
    }

}
