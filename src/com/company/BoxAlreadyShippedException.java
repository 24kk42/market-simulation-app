package com.company;

public class BoxAlreadyShippedException extends Exception {
    private final int exceptionNumber=13;

    public BoxAlreadyShippedException(){
        super("(EX: 13 box is already shipped)");
    }
}
