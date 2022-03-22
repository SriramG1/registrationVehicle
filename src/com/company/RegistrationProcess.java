package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationProcess  {
    private final Scanner in = new Scanner(System.in);

    void register() throws IOException,ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sys\\Desktop\\File\\Registration.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Details> array =(ArrayList<Details>) objectInputStream.readObject();

        Details details = new Details();

        System.out.println("Enter your Name : ");
        details.setName(in.nextLine());
        System.out.println("Enter your Number : ");
        details.setVehicleNumber(in.nextLine());
        if(!numberFormat(details.getVehicleNumber())){
            System.out.println("-----Your number is not a vehicle number-----");
            return;
        }
        if(alreadyExists(details.getVehicleNumber())){
            System.out.println("-----Your number is already exists-----");
            return;
        }
        System.out.println("Enter your District : ");
        details.setDistrict(in.nextLine());
        System.out.println("Enter your State : ");
        details.setState(in.nextLine());

        array.add(details);

        objectInputStream.close();
        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\sys\\Desktop\\File\\Registration.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(array);

        System.out.println("Register successfully...! \n Enter (Yes) for more registration (No) for back to Main Menu : ");
        char more = in.nextLine().charAt(0);
        if(more==89||more==121){
            register();
        }
        else{
            System.out.println("Thanks For Register...!");
        }
        fileOutputStream.flush();
        objectOutputStream.flush();
        fileOutputStream.close();
        objectOutputStream.close();
    }
    void display(Details details){
        System.out.println("Your name is      : "+details.getName());
        System.out.println("Your number is    : "+details.getVehicleNumber());
        System.out.println("Your district is  : "+details.getDistrict());
        System.out.println("Your state is     : "+details.getState()+"\n");
    }
    void searchByName() throws IOException,ClassNotFoundException{
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
        fileInputStream.close();
        objectInputStream.close();
    }
    void searchByNumber() throws IOException,ClassNotFoundException{

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sys\\Desktop\\File\\Registration.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Details> array=(ArrayList<Details>) objectInputStream.readObject();
        System.out.println("Enter your number for search : ");
        String number =in.nextLine();
        boolean flag=false;
        for(Details details:array){
            if(details.getVehicleNumber().equalsIgnoreCase(number)){
                flag=true;
                display(details);
            }
        }
        if(!flag){
            System.err.println("-----No valid data found in your number-----");
        }
        fileInputStream.close();
        objectInputStream.close();
    }
    void deleteAllDetails() throws IOException{
        System.out.println("Enter your password :");
        String password=in.nextLine();
        if(password.equalsIgnoreCase("Sriram")) {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\sys\\Desktop\\File\\Registration.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            ArrayList<Details> array = new ArrayList<>();
            objectOutputStream.writeObject(array);

            objectOutputStream.flush();
            fileOutputStream.close();
            objectOutputStream.close();
        }
        else{
            System.err.println("\n-----Wrong password-----\n");
        }
    }
    boolean alreadyExists(String number) throws IOException,ClassNotFoundException{
        boolean flag=false;
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sys\\Desktop\\File\\Registration.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Details> array=(ArrayList<Details>)objectInputStream.readObject();
        for(Details details : array){
            if(details.getVehicleNumber().equalsIgnoreCase(number)){
                flag=true;
            }
        }
        fileInputStream.close();
        objectInputStream.close();
        return flag;
    }
    public boolean numberFormat(String number){
        boolean check;
        check=number.matches("[A-Z]{2}\s[0-9]{2}\s[A-Z]\s[0-9]{4}");
        return check;
    }

}
