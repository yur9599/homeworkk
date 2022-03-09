package com.company.homework8.task2.customExceptions;

public class EmptyStackException extends RuntimeException{

    public EmptyStackException(){
        super();
    }

    public EmptyStackException(String message){
        super(message);
    }

}
