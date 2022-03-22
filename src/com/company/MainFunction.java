package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainFunction {
    static boolean key = true;
    Scanner in= new Scanner(System.in);
    private final RegistrationProcess register= new RegistrationProcess();

    void mainMenu() throws IOException,ClassNotFoundException{
        try {
            System.out.println(" \n(1) --> For search \n(2) --> For Registration\n(3) --> For Delete All the Records\n(4) --> For Exit \nEnter Your Choice :");
            byte choice = in.nextByte();
            switch (choice) {
                case 1:
                    System.out.println(" (1) -- > For search with vehicle number \n (2) --> For search with owner name \n Enter your choice : ");
                    int searchChoice = in.nextByte();
                    switch (searchChoice) {
                        case 1:
                            register.searchByNumber();
                            break;
                        case 2:
                            register.searchByName();
                            break;
                        default:
                            System.out.println("Enter valid option...!");
                            break;
                    }
                    break;
                case 2:
                    register.register();
                    break;
                case 3:
                    register.deleteAllDetails();
                    break;
                case 4:
                    key = false;
                    System.err.println("---------Thanks for coming----------");
                    break;
                default:
                    System.err.println("Your option is not valid...!");
                    break;
            }
        }
        catch (InputMismatchException inputMismatchException){
            System.err.println("Enter valid option...!");
        }
    }
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        MainFunction mainFunction = new MainFunction();
        System.err.println("-------Welcome-------");
        while(key) {
            mainFunction.mainMenu();
        }
    }
}
