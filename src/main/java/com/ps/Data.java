package com.ps;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalTime;
import java.time.LocalDate;

public class Data {

    private ArrayList<Transaction> transactionData;
    private HashMap< String, Transaction> transactionSearchData;


    public Data(){
        transactionData = new ArrayList<>();
        transactionSearchData = new HashMap<>();

    }

    public void addData(Transaction holderInstance) {
        transactionSearchData.put(holderInstance.getDate(), holderInstance);
        transactionData.add(holderInstance);
    }

    public void displayAllEntries(ArrayList<Transaction> transactionData){
        for(int i = transactionData.size() - 1; i  >= 0; i--){
            System.out.println(transactionData.get(i).toString());
        }
    }

    public void displayDeposits(ArrayList<Transaction> transactionData){

    }

    public void monthToDate(){
        LocalDate localDate = LocalDate.now();



    }
    public void previousMonth(){

    }

    public void yearToDate(){

    }

    public void previousYear(){

    }

}
