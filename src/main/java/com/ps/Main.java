package com.ps;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Data myData = new Data();

        try {
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line;
            while((line = buffReader.readLine()) != null){


            }

        }
        catch(IOException e){
            e.printStackTrace();

        }
    }
}
