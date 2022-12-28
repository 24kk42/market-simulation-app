package com.company;

public class Pasta extends UncountableItem{
    public Pasta(String serialNumber, double mass, double volume) {
        super("P1", serialNumber, mass, volume, 12, 28);
    }

    @Override
    public void printProduced() {
        System.out.print(this.getMass()+" kilograms of pasta has been produced with the serial number "+this.getSerialNumber());

    }
}
