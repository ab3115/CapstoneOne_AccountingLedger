package com.ps;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Main {
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        Data myLedger = new Data();

        buffAndFileReaderMethod(myLedger);
        homeScreenMenu(scanner, myLedger);

    }

    public static void buffAndFileReaderMethod(Data myLedger){

        try {
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line;
            while((line = buffReader.readLine()) != null){
                String[] tempDataHolder = line.split("\\|");
                String date = tempDataHolder[0];
                String time = tempDataHolder[1];
                String description = tempDataHolder[2];
                String vendor = tempDataHolder[3];
                float amount = Float.parseFloat(tempDataHolder[4]);
                inputToData(myLedger, date, time, description,vendor, amount);

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



    public static void fileAndBuffWriter(Data myLedger, String description, String vendor, float amount){

        try {
            LocalTime time_1 = LocalTime.now();
            LocalDate date_1 = LocalDate.now();
            DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter time_formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String date = date_1.format(date_formatter);
            String time = time_1.format(time_formatter);

            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            buffWriter.newLine();
            buffWriter.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);

            inputToData(myLedger, date, time, description, vendor, amount);
            buffWriter.close();
        }catch(Exception e){

        }
    }



    public static void homeScreenMenu(Scanner scanner, Data myLedger){
        String home_screen_input;

        do {

            System.out.println("Welcome to the Accounting Ledger Application! Please select an option!");
            System.out.println("\t(D)Add Deposit");
            System.out.println("\t(P)Make Payment(Debit)");
            System.out.println("\t(L)Ledger");
            System.out.println("\t(X)Exit");
            home_screen_input = scanner.next().toUpperCase();

                switch (home_screen_input) {
                    case ("D"):
                        addDeposit(scanner, myLedger);
                        break;
                    case ("P"):
                        makePayment(scanner, myLedger);
                        break;
                    case ("L"):
                        ledgerScreen(scanner, myLedger);
                        break;
                    case ("X"):
                        System.out.println("Closing application");
                        break;
                    default:
                        System.out.println("Please enter a valid input");
                        break;
                }




        }while(!home_screen_input.equals("X"));
    }

    public static void ledgerScreen(Scanner scanner, Data myLedger){
        String ledger_screen_input;

        do{
            System.out.println("Please select an option");
            System.out.println("\t(A)Display All Entries");
            System.out.println("\t(D)Display only Deposits");
            System.out.println("\t(P)Display only Payments");
            System.out.println("\t(R)Reports");
            System.out.println("\t(H)Home");
            ledger_screen_input = scanner.next().toUpperCase();

            switch(ledger_screen_input){
                case("A"):
                myLedger.displayAllEntries();
                    break;
                case("D"):
                myLedger.displayDeposits();
                    break;
                case("P"):
                myLedger.displayPayments();
                    break;
                case("R"):
                    reportsScreen(scanner, myLedger);
                    break;
                case("H"):
                    System.out.println("Returning Home");
                    break;
                default:
                    System.out.println("Please enter a valid input");
                    break;
            }

        }while(!ledger_screen_input.equals("H"));

    }

    public static void reportsScreen(Scanner scanner, Data myLedger){
        int reports_screen_input;

        try {

            do {
                System.out.println("Please select an option");
                System.out.println("(1)Month to Date");
                System.out.println("(2)Previous Month");
                System.out.println("(3)Year to Date");
                System.out.println("(4)Previous Year");
                System.out.println("(5)Search by Vendor");
                System.out.println("(6)Get Total Balance");
                System.out.println("(0)Exit");


                reports_screen_input = scanner.nextInt();


                switch (reports_screen_input) {
                    case (1):
                        myLedger.monthToDate();
                        break;
                    case (2):
                        myLedger.previousMonth();
                        break;
                    case (3):
                        myLedger.yearToDate();
                        break;
                    case (4):
                        myLedger.previousYear();
                        break;
                    case (5):
                        searchVendorScreen(scanner, myLedger);
                        break;
                    case (6):
                        myLedger.getTotalBalance();
                        break;
                    case (0):
                        System.out.println("Returning Home");
                        break;
                    default:
                        System.out.println("Please enter a valid input");
                        break;
                }


            } while (!(reports_screen_input == 0));
        }catch(Exception e){
            System.out.println("Please enter a valid input");

        }
    }


    public static void searchVendorScreen(Scanner scanner, Data myLedger){
        System.out.println("Please enter the name of the Vendor you'd like to search for.");
        String vendor_temp = scanner.next();
        myLedger.searchByVendor(vendor_temp);
    }



    public static void addDeposit(Scanner scanner, Data myLedger){

        System.out.println("Please enter the deposit information:");
        System.out.println("\tPlease enter the description:");
        String desc_temp = scanner.next();
        System.out.println("\tPlease enter the vendor:");
        String vendor_temp = scanner.next();
        System.out.println("\tPlease enter the amount:");
        float temp_deposit_amount = scanner.nextFloat();
        fileAndBuffWriter(myLedger, desc_temp, vendor_temp, temp_deposit_amount);

    }

    public static void makePayment(Scanner scanner, Data myLedger){

        System.out.println("Please enter your debit information:");
        System.out.println("\tPlease enter the description:");
        String desc_temp = scanner.next();
        System.out.println("\tPlease enter the vendor:");
        String vendor_temp = scanner.next();
        System.out.println("\tPlease enter the amount:");
        float temp_deposit_amount = scanner.nextFloat();
        temp_deposit_amount = temp_deposit_amount * -1;
        fileAndBuffWriter(myLedger, desc_temp, vendor_temp, temp_deposit_amount);

    }




}
