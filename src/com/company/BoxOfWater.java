package com.company;

public class BoxOfWater extends CountableItem {
    public BoxOfWater(String serialNumber, double volume) {
        super("W1", serialNumber, volume, 1, 3);
    }

    @Override
    public void printProduced() {
        System.out.print(this.getVolume()+" liter of box of water has been produced with the serial number "+this.getSerialNumber());

    }
}
