package com.company;

public class NumberBox<T extends IItem> extends Box<T>{

    public NumberBox(String serialNumber, double numberOfItems, double volume) {
        super("B1", serialNumber, numberOfItems, volume,2);
    }

    @Override
    public void printProduced() {
        System.out.print(this.getVolume()+" liters of number box has been produced with capacity of "+ this.getCurrentSize() +" with the serial number "+this.getSerialNumber());
    }
}
