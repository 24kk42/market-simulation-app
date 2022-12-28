package com.company;

public class BoxCapacityException extends Exception{

    private final int exceptionNumber=11;

    public BoxCapacityException(){
        super("(EX: 11 box capacity is full)");
    }
}
