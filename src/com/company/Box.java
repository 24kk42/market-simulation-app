package com.company;

import java.util.ArrayList;

public abstract class Box<T extends IItem> implements IBox<T>{
    private String boxCode;
    private double currentSize;
    private double volume;

    private int cost;
    private String serialNumber;
    private ArrayList<T> contents;
    private boolean isLoaded;
    private boolean isShipped;
    private double totalCost;
    private boolean isPuttable;


    public Box(String boxCode,String serialNumber, double currentSize, double volume, int cost){
        this.boxCode = boxCode;
        this.currentSize = currentSize;
        this.totalCost= calculateCost(cost, volume);
        this.volume = volume;
        this.serialNumber = serialNumber;
        this.isLoaded=false;
        this.isShipped=false;
        this.isPuttable=true;
        contents = new ArrayList<>();
    }

    public double getCurrentSize(){
        return this.currentSize;
    }

    public String getBoxCode(){
        return this.boxCode;
    }

    public void setCurrentSize(double i){
        this.currentSize -= i ;
    }

    public double getVolume(){
        return this.volume;
    }

    public void setVolume(double i){
        this.volume -= i ;
    }

    public String getSerialNumber(){
        return this.serialNumber;
    }

    public ArrayList<T> getContents(){
        return this.contents ;
    }

    public int getCost(){ return this.cost;}

    public boolean getIsLoaded(){return this.isLoaded;}

    public void setIsLoaded(){
        this.isLoaded=(!this.isLoaded);
    }

    public double calculateCost(int boxCost, double volume){
        return boxCost * volume ;
    }

    public double getTotalCost(){
        return this.totalCost;
    }

    public boolean getIsShipped(){return this.isShipped;}

    public void setIsShipped(){
        this.isShipped=(!this.isShipped);
    }

    public boolean getIsPuttable(){return this.isPuttable;}

    public void setIsPuttable(){
        this.isPuttable=(!this.isPuttable);
    }

    public boolean putItem(IItem item){
        try{
            if(this.isPuttable){
                if(item.getIsStored()){
                    //throw error item already produced
                    throw new ItemAlreadyStoredException();
                }
                else{
                    if(item.isCountable()){
                        if(this.getVolume()<item.getVolume() || this.getCurrentSize()<=0 ){
                            throw new BoxCapacityException();
                        }else{
                            //valid situation
                            this.volume-=item.getVolume();
                            this.currentSize -= 1;
                            item.setIsStored();
                            this.contents.add((T) item);
                            System.out.println("Item "+item.getSerialNumber()+" has been placed to the box "+this.serialNumber);
                            return true;
                        }
                    }
                    else {
                        UncountableItem tempItem = (UncountableItem) item ;
                        if(this.getVolume()<item.getVolume() || this.getCurrentSize()< tempItem.getMass() ){
                            throw new BoxCapacityException();
                        }else{
                            //valid situation
                            this.volume-=item.getVolume();
                            this.currentSize -= tempItem.getMass();
                            item.setIsStored();
                            this.contents.add((T) item);
                            System.out.println("Item "+item.getSerialNumber()+" has been placed to the box "+this.serialNumber);
                            return true;
                        }

                    }

            }
            }
            else{
                throw new BoxIsNotPuttableException();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
}
