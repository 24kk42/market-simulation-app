package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileIO fileIO=new FileIO();
        CompanyManagement companyManagement=new CompanyManagement(fileIO);
    }
}
