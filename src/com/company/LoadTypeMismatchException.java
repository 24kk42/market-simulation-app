package com.company;

public class LoadTypeMismatchException extends Exception{

    private final int exceptionNumber=9;

    public LoadTypeMismatchException(){
        super("(EX: 9 Loaded and load types do not match)");
    }
}
