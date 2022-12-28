package com.company;

import java.util.Hashtable;

public interface ICompany {

    public double getRevenue();

    public void setRevenue(double revenue);

    public Hashtable<String,IItem> getItems();

    public Hashtable<String,IBox<IItem>> getBoxes();

    public Hashtable<String,IContainer> getContainers();

    public void addItem(IItem item);

    public void addBox(IBox<IItem> box);

    public void addContainer(IContainer container);

    public boolean isItemExist(IItem item);

    public boolean isBoxExist(IBox<IItem> box);

    public boolean isContainerExist(IContainer container);

    public double computeUnearnedRevenue();
}
