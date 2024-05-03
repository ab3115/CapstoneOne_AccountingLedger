package com.ps;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Data {

    private ArrayList<Transaction> transactionData;
    CustomSearch searchClass = new CustomSearch();





    public Data() {
        transactionData = new ArrayList<>();
    }

    public void addData(Transaction holderInstance) {
        transactionData.add(holderInstance);
    }

    public void displayAllEntries() {
        for (int i = transactionData.size() - 1; i >= 0; i--) {
            System.out.println(transactionData.get(i).toString());
        }
    }





    public void displayDeposits(){
        boolean deposit_found = false;
        for (int i = transactionData.size() - 1; i >= 0; i--){
            if(transactionData.get(i).getAmount() > 0){
                System.out.println(transactionData.get(i).toString());
                deposit_found = true;
            }
        }
        if(!deposit_found){
            System.out.println("There are no deposits in the CSV file.");
        }
    }





    public void displayPayments(){
        boolean payment_found = false;
        for (int i = transactionData.size() - 1; i >= 0; i--){
            if(transactionData.get(i).getAmount() < 0){
                System.out.println(transactionData.get(i).toString());
                payment_found = true;
            }
        }
        if(!payment_found){
            System.out.println("There are no payments in the CSV file.");
        }
    }




    public void monthToDate() {
        boolean foundMtoD = false;
        LocalDate localDate = LocalDate.now();
        int current_month = localDate.getMonthValue();
        int current_year = localDate.getYear();



        for(int i = 0; i < transactionData.size(); i++){
            int instance_month = Integer.parseInt(transactionData.get(i).getDate().substring(5, 7));
            int instance_year = Integer.parseInt(transactionData.get(i).getDate().substring(0, 4));

            if(instance_month == current_month && instance_year == current_year){
                System.out.println(transactionData.get(i).toString());
                foundMtoD = true;
            }

        }

        if(!foundMtoD){
            System.out.println("No records found since beginning of this month.");
        }

    }




    public void previousMonth() {
        boolean found_previous_month = false;
        LocalDate localDate = LocalDate.now();
        int current_month = localDate.getMonthValue();
        int current_year = localDate.getYear();
        int previous_month = current_month - 1;
        if (previous_month == 0) {
            previous_month = 12;
            current_year--;
        }



        for (int i = 0; i < transactionData.size(); i++) {
            int instance_month = Integer.parseInt(transactionData.get(i).getDate().substring(5, 7));
            int instance_year = Integer.parseInt(transactionData.get(i).getDate().substring(0, 4));

            if ((instance_month == previous_month) && (instance_year == current_year)) {
                System.out.println(transactionData.get(i).toString());
                found_previous_month = true;
            }

        }
        if(!found_previous_month){
            System.out.println("No records found for the previous month.");
        }
    }



    public void yearToDate(){
        boolean foundYtoD = false;
        LocalDate localDate = LocalDate.now();
        int current_month = localDate.getMonthValue();
        int current_year = localDate.getYear();
        int current_day = localDate.getDayOfMonth();

        for(int i = 0; i < transactionData.size(); i++){
            int instance_month = Integer.parseInt(transactionData.get(i).getDate().substring(5, 7));
            int instance_year = Integer.parseInt(transactionData.get(i).getDate().substring(0, 4));
            int instance_day = Integer.parseInt(transactionData.get(i).getDate().substring(8));

            if((instance_year == current_year && instance_month == current_month && instance_day <= current_day) ||
                    (instance_year == current_year && current_month > instance_month)){
                System.out.println(transactionData.get(i).toString());
                foundYtoD = true;
            }

        }
        if(!foundYtoD){
            System.out.println("No records found since the beginning of this year");
        }

    }



    public void previousYear(){
        boolean found_previousYear = false;
        LocalDate localDate = LocalDate.now();
        int current_year = localDate.getYear();
        int previous_year = current_year - 1;

        for(int i = 0; i < transactionData.size(); i++){
            int instance_year = Integer.parseInt(transactionData.get(i).getDate().substring(0, 4));
            if(instance_year == previous_year){
                System.out.println(transactionData.get(i).toString());
                found_previousYear = true;
            }
        }

        if(!found_previousYear){
            System.out.println("No records found of the previous year");
        }

    }

    public void searchByVendor(String vendor){
        boolean vendorFound = false;

        for(int i = 0; i < transactionData.size(); i++){
            if(transactionData.get(i).getVendor().contains(vendor)){
                System.out.println(transactionData.get(i).toString());
                vendorFound = true;
            }
        }
        if(!vendorFound){
            System.out.println("The vendor you searched for was not found");
        }
    }





    public void getTotalBalance(){

        float total_sum = 0;
        for(int i = 0; i < transactionData.size(); i++){
            total_sum += transactionData.get(i).getAmount();
        }
        System.out.println("The total sum of your accounting ledger is: $ " + total_sum);
    }



    public ArrayList<Transaction> getTransactionData() {
        return transactionData;
    }
}
