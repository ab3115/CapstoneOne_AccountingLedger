package com.ps;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Data {

    private ArrayList<Transaction> transactionData;
    private HashMap<String, Transaction> transactionSearchDate;


    public Data() {
        transactionData = new ArrayList<>();
        transactionSearchDate = new HashMap<>();

    }

    public void addData(Transaction holderInstance) {
        transactionSearchDate.put(holderInstance.getDate(), holderInstance);
        transactionData.add(holderInstance);
    }

    public void displayAllEntries() {
        for (int i = transactionData.size() - 1; i >= 0; i--) {
            System.out.println(transactionData.get(i).toString());
        }
    }

    public void displayDeposits(){
        for (int i = transactionData.size() - 1; i >= 0; i--){
            if(transactionData.get(i).getAmount() > 0){
                System.out.println(transactionData.get(i).toString());
            }
        }
    }

    public void displayPayments(){
        for (int i = transactionData.size() - 1; i >= 0; i--){
            if(transactionData.get(i).getAmount() < 0){
                System.out.println(transactionData.get(i).toString());
            }
        }
    }

    public void monthToDate() {
        LocalDate localDate = LocalDate.now();
        int current_month = localDate.getMonthValue();
        int current_year = localDate.getYear();
        int current_day = localDate.getDayOfMonth();


        for(int i = 0; i < transactionData.size(); i++){
            int instance_month = Integer.parseInt(transactionData.get(i).getDate().substring(5, 7));
            int instance_year = Integer.parseInt(transactionData.get(i).getDate().substring(0, 4));
            int instance_day = Integer.parseInt(transactionData.get(i).getDate().substring(8, 10));
            if(instance_month == current_month && instance_year == current_year && instance_day <= current_day){
                System.out.println(transactionData.get(i).toString());
            }

        }

    }


    public void previousMonth() {
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
            }

        }
    }

    public void yearToDate(){
        LocalDate localDate = LocalDate.now();
        int current_month = localDate.getMonthValue();
        int current_year = localDate.getYear();
        int current_day = localDate.getDayOfMonth();

        for(int i = 0; i < transactionData.size(); i++){
            int instance_month = Integer.parseInt(transactionData.get(i).getDate().substring(5, 7));
            int instance_year = Integer.parseInt(transactionData.get(i).getDate().substring(0, 4));
            int instance_day = Integer.parseInt(transactionData.get(i).getDate().substring(8, 10));
            if(instance_year == current_year && instance_month<= current_month && instance_day <= current_day){
                System.out.println(transactionData.get(i).toString());
            }

        }

    }

    public void previousYear(){
        LocalDate localDate = LocalDate.now();
        int current_month = localDate.getMonthValue();
        int current_year = localDate.getYear();
        int previous_year = current_year - 1;
        for(int i = 0; i < transactionData.size(); i++){
            int instance_year = Integer.parseInt(transactionData.get(i).getDate().substring(0, 4));
            if(instance_year == previous_year){
                System.out.println(transactionData.get(i).toString());
            }
        }

    }

    public void searchByVendor(){

    }

}
