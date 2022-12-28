package com.company;

public class Flour extends UncountableItem{
    public Flour(String serialNumber, double mass, double volume) {
        super("F1", serialNumber, mass, volume, 5, 12);
    }

    @Override
    public void printProduced() {
        System.out.print(this.getMass()+" kilograms of flour has been produced with the serial number "+this.getSerialNumber());

    }
}
