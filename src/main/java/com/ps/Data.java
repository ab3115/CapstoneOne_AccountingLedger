package com.ps;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

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

    public void displayDeposits(ArrayList<Transaction> transactionData) {

    }

    public void monthToDate(ArrayList<Transaction> transactionData) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM");
        String localMonth = localDate.format(monthFormatter);

        for(int i = 0; i < transactionData.size(); i++){
            if(transactionData.get(i).getDate().substring(5,7).equals(localMonth)){
                System.out.println(transactionData.get(i).toString());
            }
        }

    }








    public void previousMonth(){


    }

    public void yearToDate(){

    }

    public void previousYear(){

    }

    public void searchByVendor(){

    }

}
