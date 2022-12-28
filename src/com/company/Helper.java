package com.company;

import java.util.ArrayList;

public class Helper {

    public String[] codes={"M1","W1","O1","S1","F1","P1","R1","B1","B2","C1"};

    public  int defineItemOrBoxWithCode(String codeInput){
        for(int i=0;i<codes.length;i++){
            if(codes[i].equals(codeInput)){
                return i;
            }
        }
        //not found
        return -1;
    }


    public IItem createItem(int index, ArrayList<String> line){
        //index should be between 0 and 6
        switch(index) {
            //box of milk
            case 0:
                return new BoxOfMilk(line.get(3),Double.parseDouble(line.get(2)));
            //box of water
            case 1:
                return new BoxOfWater(line.get(3),Double.parseDouble(line.get(2)));
            //box of oil
            case 2:
                return new BoxOfOil(line.get(3),Double.parseDouble(line.get(2)));
            //sugar
            case 3:
                return new Sugar(line.get(4),Double.parseDouble(line.get(2)),Double.parseDouble(line.get(3)));
            //flour
            case 4:
                return new Flour(line.get(4),Double.parseDouble(line.get(2)),Double.parseDouble(line.get(3)));
            //pasta
            case 5:
                return new Pasta(line.get(4),Double.parseDouble(line.get(2)),Double.parseDouble(line.get(3)));
            //rice
            case 6:
                return new Rice(line.get(4),Double.parseDouble(line.get(2)),Double.parseDouble(line.get(3)));
            default:
                return null;
        }
    }


    public IBox<IItem> createBox(int index, ArrayList<String> line){
        //index should be between 7 and 8
        switch(index) {
            //number box
            case 7:
                return new NumberBox<IItem>(line.get(4),Double.parseDouble(line.get(2)),Double.parseDouble(line.get(3)));
            //mass box
            case 8:
                return new MassBox<IItem>(line.get(4),Double.parseDouble(line.get(2)),Double.parseDouble(line.get(3)));
            default:
                return null;
        }
    }

    public IContainer createContainer(ArrayList<String> line){
        //index should be 9, so no need to take index as a parameter.

        //container
        return new Container(Double.parseDouble(line.get(2)),line.get(3));
    }

}
