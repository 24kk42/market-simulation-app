package com.company;

public class ItemLoadTypeContainerException extends Exception{

    private final int exceptionNumber=8;

    public ItemLoadTypeContainerException(){
        super("(EX: 8 item can not be loaded into a container )");
    }
}
