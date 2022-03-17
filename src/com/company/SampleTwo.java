package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SampleTwo {
    static void display(Details details){
        System.out.println("Your name is      : "+details.getName());
        System.out.println("Your number is    : "+details.getVehicleNumber());
        System.out.println("Your district is  : "+details.getDistrict());
        System.out.println("Your state is     : "+details.getState());
    }
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Scanner in =  new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sys\\Desktop\\File\\Registration.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Details> array=(ArrayList<Details>) objectInputStream.readObject();
        System.out.println("Enter your name for search : ");
        String name =in.nextLine();
        boolean flag=false;
        for(Details details:array){
            if(details.getName().equalsIgnoreCase(name)){
                flag=true;
                display(details);
            }
        }
        if(!flag){
            System.err.println("-----No valid data found in your number-----");
        }
    }
}
