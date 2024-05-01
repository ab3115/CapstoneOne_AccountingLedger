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









    }

    public static void buffAndFileReaderMethod(Data myLedger){
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
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void homeScreenMenu(Scanner scanner){
        String home_screen_input;

        do {
            System.out.println("Welcome to the Accounting Ledger Application! Please select an option!");
            System.out.println("\t D");
            System.out.println("\t P");
            System.out.println("\t L");
            System.out.println("\t X");
            home_screen_input = scanner.next();

            switch (home_screen_input){
                case("D"):
                    break;
                case("P"):
                    break;
                case("L"):
                    break;
                case("X"):
                    break;
                default:
                    break;
            }
        }while(!home_screen_input.equals("X"));
    }


}
