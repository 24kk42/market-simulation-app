package com.company;

public class SerialNumberAlreadyExistsException extends Exception {

    private final int exceptionNumber=5;

    public SerialNumberAlreadyExistsException(){
        super("(EX: 5 existing serial number)");
    }
}
