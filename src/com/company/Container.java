package com.company;

import java.util.ArrayList;

public class Container implements IContainer {

    private int cost;
    private String containerCode;
    private String serialNumber;
    private boolean isShipped;
    private double volume;
    private double totalCost;

    private ArrayList<IBox<IItem>> boxes;


    public Container(double volume, String serialNumber){
        this.cost=1;
        this.totalCost = calculateCost(this.cost, volume);
        this.containerCode="C1";
        this.volume=volume;
        this.isShipped=false;
        this.serialNumber=serialNumber;
        boxes=new ArrayList<>();
    }

    @Override
    public String getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public String getContainerCode() {
        return this.containerCode;
    }

    @Override
    public double calculateCost(int cost, double volume) {
        return cost*volume;
    }

    @Override
    public double getTotalCost() {
        return this.totalCost;
    }

    @Override
    public boolean load(double volume) {
        try {
            if(this.volume<volume){
                throw new ContainerCapacityFullException();
            }
        }catch (ContainerCapacityFullException e){
            System.out.println(e.getMessage());
            return false;
        }
        this.volume-=volume;
        return true;
    }

    @Override
    public void printProduced() {
        System.out.print(this.volume+" liters of container has been produced with the serial number "+this.serialNumber);
    }

    @Override
    public boolean getIsShipped() {
        return this.isShipped;
    }

    @Override
    public void setIsShipped() {
        this.isShipped=(!isShipped);
    }

    @Override
    public boolean putBox(IBox box) {


        try {
           if(!box.getIsShipped()){
               //container volume control
               if(box.getVolume()>this.volume){
                   throw new ContainerCapacityFullException();
               }

               box.setIsPuttable();
               this.volume-=box.getVolume();
               this.boxes.add(box);
               //print statement
               System.out.println("Box "+box.getSerialNumber()+" has been placed to the container "+this.getSerialNumber());

               return true;
           }
           else{
               throw new BoxAlreadyShippedException();
           }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<IBox<IItem>> getBoxes() {
        return this.boxes;
    }

    @Override
    public double ship() {
        try {
            //container can be shipped only one time
            if(this.isShipped){
                throw new ContainerAlreadyShippedException();
            }

            //set true all of boxes isshipped
            for (IBox<IItem> box: boxes) {
                box.getIsShipped();
                for (IItem item: box.getContents()) {
                    item.setIsShipped();
                }
            }
            this.isShipped=true;


            return calculateRevenueFromBoxes(this.boxes);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public double calculateRevenueFromBoxes(ArrayList<IBox<IItem>> boxes) {
        double totalRevenue=0;
        for (IBox<IItem> box: boxes) {
            for (IItem item: box.getContents()) {
                totalRevenue+=item.getPrice();
            }
        }
        return totalRevenue;
    }

}
