package com.company;

import java.util.ArrayList;

public interface IContainer {

    public String getSerialNumber();

    public double getVolume();

    public int getCost();

    public String getContainerCode();

    public boolean load(double volume);

    public void printProduced();

    //company sell
    public boolean getIsShipped();

    public double calculateCost(int cost, double volume);

    public double getTotalCost();

    public void setIsShipped();

    public boolean putBox(IBox box);

    public ArrayList<IBox<IItem>> getBoxes();

    public double ship();

    public double calculateRevenueFromBoxes(ArrayList<IBox<IItem>> boxes);


}
