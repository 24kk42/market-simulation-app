package com.company;

public class ContainerAlreadyShippedException extends Exception{
    private final int exceptionNumber=15;

    public ContainerAlreadyShippedException(){
        super("(EX: 15 container already been shipped)");
    }
}
