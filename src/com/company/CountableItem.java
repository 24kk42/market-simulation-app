package com.company;

public abstract class CountableItem extends Item {
    private double cost;

    public CountableItem(String itemCode, String serialNumber, double volume, int costPerLiter, int pricePerLiter) {
        super(itemCode, serialNumber, volume, pricePerLiter);
        this.cost = calculateCost(costPerLiter, volume);
    }

    private double calculateCost(int valuePerUnit, double volume){
        return valuePerUnit * volume ;
    }

    public double getCost(){
        return this.cost;
    }

    @Override
    public boolean isCountable() {
        return true;
    }
}
