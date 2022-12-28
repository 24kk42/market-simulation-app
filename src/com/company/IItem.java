package com.company;


public interface IItem {
    public String getSerialNumber();

    public String getItemCode();

    public double getCost();

    public double getPrice();

    public double getVolume();

    //company buy
    public boolean getIsStored();

    public void setIsStored();

    public void printProduced();

    //company sell
    public boolean getIsShipped();

    public void setIsShipped();

    public boolean isCountable();
}
