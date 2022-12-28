package com.company;

public abstract class UncountableItem extends Item {
    private double mass;
    private double cost;



    public UncountableItem(String itemCode, String serialNumber, double mass, double volume, int costPerMass, int pricePerLiter) {
        super(itemCode, serialNumber, volume, pricePerLiter);
        this.mass = mass;
        this.cost = calculateCost(costPerMass,mass);

    }

    private double calculateCost(int valuePerUnit, double mass){
        return valuePerUnit * mass ;
    }

    public double getMass() {
        return this.mass;
    }

    public double getCost(){
        return this.cost;
    }

    @Override
    public boolean isCountable() {
        return false;
    }
}
