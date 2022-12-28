package com.company;

import java.util.ArrayList;

public interface IBox<T extends IItem> {
    public void setCurrentSize(double i);

    public double getCurrentSize();

    public void setVolume(double i);

    public int getCost();

    public double getVolume();

    public String getBoxCode();

    public String getSerialNumber();

    public ArrayList<T> getContents();

    public boolean getIsLoaded();

    public double calculateCost(int boxCost, double volume);

    public double getTotalCost();

    public void printProduced();

    //company sell
    public boolean getIsShipped();

    public boolean getIsPuttable();

    public void setIsPuttable();

    public boolean putItem(IItem item);

    public void setIsShipped();
}
