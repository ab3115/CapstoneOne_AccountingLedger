package com.ps;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;


public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Data myLedger = new Data();

        try {
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line;
            while((line = buffReader.readLine()) != null){
                String[] tempDataHolder = line.split("\\|");
                String date = tempDataHolder[0];
                String time =tempDataHolder[1];
                String description = tempDataHolder[2];
                String vendor = tempDataHolder[3];
                float amount = Float.parseFloat(tempDataHolder[4]);
                Transaction holderInstance = new Transaction(date, time, description, vendor, amount);
                myLedger.addData(holderInstance);

            }

        }
        catch(IOException e){
            e.printStackTrace();

        }
    }
}
