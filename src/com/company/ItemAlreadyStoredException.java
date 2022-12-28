package com.company;

public class ItemAlreadyStoredException extends Exception{
    private final int exceptionNumber=10;

    public ItemAlreadyStoredException(){
        super("(EX: 10 item has already been stored)");
    }
}
