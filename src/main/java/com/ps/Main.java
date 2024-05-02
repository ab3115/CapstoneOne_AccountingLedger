package com.ps;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Main {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        Data myLedger = new Data();
        homeScreenMenu(scanner);

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
                inputToData(myLedger, date,time, description,vendor, amount);
                buffReader.close();
            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void inputToData(Data myLedger, String date, String time, String description, String vendor, float amount){
        Transaction holderInstance = new Transaction(date, time, description, vendor, amount);
        myLedger.addData(holderInstance);
    }

    public static void fileAndBuffWriter(Data myLedger, String date, String time, String description, String vendor, float amount){

        try {

            FileWriter fileWriter = new FileWriter("transactions.csv");
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            buffWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);
            inputToData(myLedger, date, time, description, vendor, amount);
            buffWriter.close();
        }catch(Exception e){

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

    public static void ledgerScreen(Scanner scanner){
        String ledger_screen_input;

    }

    public static void reportsScreen(Scanner scanner){
        String reports_screen_input;
    }

    public static void addDeposit(Scanner scanner){
        System.out.println("Please enter the deposit information");
        System.out.println("\tPlease enter the date of the deposit");
        String date_temp = scanner.next();
        System.out.println("\tPlease enter the time of the transaction");
        String time_temp = scanner.next();
        System.out.println("\tPlease enter the description");
        String desc_temp = scanner.next();
        System.out.println("\tPlease enter the vendor");
        String vendor_temp = scanner.next();
        String temp_deposit_amount = scanner.next();

    }

    public static void makePayment(Scanner scanner){
        System.out.println("Please enter your debit information");
        String temp_make_payment = scanner.next();
        //save to csv

    }




}
