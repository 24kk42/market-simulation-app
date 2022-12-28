package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class CompanyManagement {


    private Helper helper;

    private Company company;

    public CompanyManagement(FileIO fileIO) throws IOException {
        company=new Company();

        this.initializeDataBase(fileIO);
    }

    private void initializeDataBase(FileIO fileIO) throws IOException {

        ArrayList<ArrayList<String>> lines= fileIO.readLines();
        helper=new Helper();

        for (ArrayList<String> line:lines) {

            //for empty lines
            if(line.size()>1){

                int index=Integer.parseInt(line.get(0));

                //produce
                if(index==1){
                    String code =line.get(1);

                    //check code
                    int codeIndex=helper.defineItemOrBoxWithCode(code);

                    // check item or box-container

                    //item index
                    if(codeIndex!= 7 && codeIndex!=8 &&codeIndex!=9){
                        //create item with helper class
                        IItem item=helper.createItem(codeIndex,line);
                        //insert into company's item list
                        this.company.addItem(item);
                    }
                    //box index
                    else if(codeIndex!=9){
                        //create box with helper class
                        IBox<IItem> box=helper.createBox(codeIndex,line);
                        //insert into company's box list
                        this.company.addBox(box);
                    }
                    //container
                    else{
                        //create container with helper class
                        IContainer container=helper.createContainer(line);
                        //insert into company's container list
                        this.company.addContainer(container);
                    }
                }
                //load
                else if(index==2){
                    try {
                        String serialNumber1=line.get(1);
                        String serialNumber2=line.get(2);
                        IItem item;
                        IBox box;

                        //first one is item
                        if(this.company.getItems().containsKey(serialNumber1)){
                            //first one is item second one is box
                            if(this.company.getBoxes().containsKey(serialNumber2)){
                                item=this.company.getItems().get(serialNumber1);
                                box=this.company.getBoxes().get(serialNumber2);

                                    //item is countable, box is number box
                                    if(item.isCountable() && box.getBoxCode().equals("B1")){
                                        //store item into box
                                        box.putItem(item);
                                    }
                                    //item is uncountable, box is mass box
                                    else if(!item.isCountable() && box.getBoxCode().equals("B2")){
                                        //store item into box
                                        box.putItem(item);
                                    }
                                    // item and box are not same type
                                    else{
                                        throw new LoadTypeMismatchException();
                                    }
                            }
                                //first one is item second one is container
                                if(this.company.getContainers().containsKey(serialNumber2)){
                                    throw new ItemLoadTypeContainerException();
                                }

                        }


                        //first one is box
                        else if(this.company.getBoxes().containsKey(serialNumber1)){
                            //first one is box second one is container
                            if(this.company.getContainers().containsKey(serialNumber2)){
                                IContainer container=this.company.getContainers().get(serialNumber2);
                                box=this.company.getBoxes().get(serialNumber1);
                                container.putBox(box);

                            }
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                }
                //ship
                else if(index==3){

                    String serialNumber=line.get(1);

                    IContainer container=company.getContainers().get(serialNumber);

                    this.company.setRevenue(container.ship());

                    System.out.println("Container "+ serialNumber+" has been shipped\t"+"Revenue: "+this.company.getRevenue());
                }
                //show
                else if(index==4){
                    if(line.get(1).equals("1")){
                        System.out.println("Unearned revenue: "+this.company.computeUnearnedRevenue()+"₺");
                    }
                    else if(line.get(1).equals("2")){
                        System.out.println("Total revenue: "+ (int) this.company.getRevenue()+"₺");
                    }
                }
                else {
                    //for broken lines
                }
            }
        }
    }
}
