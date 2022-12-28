package com.company;

public class MassBox<T extends IItem> extends Box<T>{
    public MassBox(String serialNumber, double mass, double volume) {
        super("B2", serialNumber, mass, volume,3);

    }



    @Override
    public void printProduced() {
        System.out.print(this.getVolume()+" liters of mass box has been produced with capacity of "+ this.getCurrentSize() +"kg with the serial number "+this.getSerialNumber());
    }
}
