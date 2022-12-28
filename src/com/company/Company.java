package com.company;


import java.util.Hashtable;

public class Company implements ICompany {

    private  double revenue;

    private Hashtable<String,IItem> items;

    private Hashtable<String,IBox<IItem>> boxes;

    private Hashtable<String,IContainer> containers;

    public Company(){
        this.revenue=0;
        items=new Hashtable<>();
        boxes=new Hashtable<>();
        containers=new Hashtable<>();
    }

    @Override
    public double getRevenue() {
        return  this.revenue;
    }

    @Override
    public void setRevenue(double revenue) {
        this.revenue=revenue;
    }

    @Override
    public Hashtable<String,IItem> getItems() {
        return this.items;
    }

    @Override
    public Hashtable<String,IBox<IItem>> getBoxes() {
        return this.boxes;
    }

    @Override
    public Hashtable<String,IContainer> getContainers() {
        return this.containers;
    }

    @Override
    public void addItem(IItem item) {
        if(isItemExist(item)){
            this.items.put(item.getSerialNumber(),item);
            //reduce revenue
            this.revenue-=item.getCost();

            //print console informations
            item.printProduced();
            System.out.println("\tRevenue: "+ (int) this.revenue+"₺");
        }
    }

    @Override
    public void addBox(IBox<IItem> box) {
        if(isBoxExist(box)){
            this.boxes.put(box.getSerialNumber(),box);

            //reduce revenue
            this.revenue-=box.getTotalCost();

            //print console informations
            box.printProduced();
            System.out.println("\tRevenue: "+ (int) this.revenue+"₺");
        }
    }

    @Override
    public void addContainer(IContainer container) {
        if(isContainerExist(container)){
            this.containers.put(container.getSerialNumber(),container);

            //reduce revenue
            this.revenue-=container.getTotalCost();

            //print console informations
            container.printProduced();
            System.out.println("\tRevenue: "+ (int) this.revenue+"₺");
        }
    }

    @Override
    public boolean isItemExist(IItem item) {
        for (IItem iterateItem: this.items.values()) {
            //exception handling
            try{
                if(iterateItem.getSerialNumber().equals(item.getSerialNumber())){
                    throw new SerialNumberAlreadyExistsException();
                }
                //catch exception
            }catch (SerialNumberAlreadyExistsException e){
                System.out.println("Item with the serial number "+item.getSerialNumber()+" cannot be produced "+e.getMessage()+"\t Revenue: "+this.revenue+"₺");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isBoxExist(IBox<IItem> box) {
        for (IBox<IItem> iterateBox: this.boxes.values()) {
            //exception handling
            try{
                if(iterateBox.getSerialNumber().equals(box.getSerialNumber())){
                    throw new SerialNumberAlreadyExistsException();
                }
                //catch exception
            }catch (SerialNumberAlreadyExistsException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isContainerExist(IContainer container) {
        for (IContainer iterateContainer: this.containers.values()) {
            //exception handling
            try{
                if(iterateContainer.getSerialNumber().equals(container.getSerialNumber())){
                    throw new SerialNumberAlreadyExistsException();
                }
                //catch exception
            }catch (SerialNumberAlreadyExistsException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public double computeUnearnedRevenue() {
        double unearnedRevenue=0;
        for (IItem item:this.items.values()) {
            if(!item.getIsShipped()){
                unearnedRevenue+=item.getPrice();
            }
        }
        return unearnedRevenue;

    }

}
