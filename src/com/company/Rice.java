package com.company;

public class Rice extends UncountableItem{
    public Rice(String serialNumber, double mass, double volume) {
        super("R1", serialNumber, mass, volume, 16, 32);
    }

    @Override
    public void printProduced() {
        System.out.print(this.getMass()+" kilograms of rice has been produced with the serial number\t"+this.getSerialNumber());

    }
}
