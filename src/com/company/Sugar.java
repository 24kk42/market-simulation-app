package com.company;

public class Sugar extends UncountableItem{
    public Sugar(String serialNumber, double mass, double volume) {
        super("S1", serialNumber, mass, volume, 13, 25);
    }

    @Override
    public void printProduced() {
        System.out.print(this.getMass()+" kilograms of sugar has been produced with the serial number "+this.getSerialNumber());
    }
}
