package com.company;

public class BoxIsNotPuttableException extends Exception{

    private final int exceptionNumber=4;

    public BoxIsNotPuttableException(){
        super("(EX: 5 box has already loaded )");
    }
}
