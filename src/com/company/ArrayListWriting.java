package com.company;

import java.io.*;
import java.util.ArrayList;

public class ArrayListWriting {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\sys\\Desktop\\File\\Registration.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ArrayList<Details> array = new ArrayList<>();
        objectOutputStream.writeObject(array);

        objectOutputStream.flush();
        fileOutputStream.close();
        objectOutputStream.close();
    }
}
