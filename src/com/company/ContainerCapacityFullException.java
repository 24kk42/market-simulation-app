package com.company;

public class ContainerCapacityFullException extends Exception{
    private final int exceptionNumber=6;

    public ContainerCapacityFullException(){
        super("(EX: 6 container capacity is full)");
    }

}
