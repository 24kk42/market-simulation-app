package com.company;

public class BoxOfOil extends CountableItem{
    public BoxOfOil(String serialNumber, double volume) {
        super("O1", serialNumber, volume, 20, 45);
    }

    @Override
    public void printProduced() {
        System.out.print(this.getVolume()+" liter of box of oil has been produced with the serial number "+this.getSerialNumber());

    }
}
