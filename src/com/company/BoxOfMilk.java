package com.company;

public class BoxOfMilk extends CountableItem {
    public BoxOfMilk(String serialNumber, double volume) {
        super("M1", serialNumber, volume, 5, 11);
    }

    @Override
    public void printProduced() {
        System.out.print(this.getVolume()+" liter of box of milk has been produced with the serial number "+this.getSerialNumber());
    }
}
