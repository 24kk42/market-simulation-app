package com.company;

public abstract class Item implements IItem {
    private String itemCode;
    private String serialNumber;
    private double volume;
    private double price;
    private boolean isStored;
    private boolean isProduced;
    private boolean isShipped;
    public  Item(String itemCode, String serialNumber, double volume, int pricePerUnit){
        this.itemCode = itemCode;
        this.serialNumber = serialNumber;
        this.volume = volume;
        this.isProduced=false;
        this.isShipped=false;
        this.isStored=false;
        this.price = calculatePrice(pricePerUnit, volume);
    }

    private double calculatePrice(int valuePerUnit, double volume){
        return valuePerUnit * volume ;
    }

    public String getSerialNumber(){
        return this.serialNumber;
    }

    public String getItemCode(){
        return this.itemCode;
    }

    public double getVolume(){
        return this.volume;
    }

    public double getPrice(){
        return this.price;
    }



    public boolean getIsStored(){
        return this.isStored;
    }

    public void setIsStored(){
        this.isStored=(!this.isStored);
    }

    @Override
    public boolean getIsShipped() {
        return this.isShipped;
    }

    @Override
    public void setIsShipped() {
        this.isShipped=(!isShipped);
    }
}

