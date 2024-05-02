package com.ps;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {

    private ArrayList<Transaction> transactionData;
    private HashMap< String, Transaction> transactionSearchData;
    private HashMap< Integer , Transaction> transactionSearchByAmount;

    public Data(){
        transactionData = new ArrayList<>();
        transactionSearchData = new HashMap<>();
        transactionSearchByAmount = new HashMap<>();
    }

    public void addData(Transaction holderInstance) {
        transactionSearchData.put(holderInstance.getDate(), holderInstance);
        transactionSearchByAmount.put(holderInstance.getAmount(), holderInstance);
        transactionData.add(holderInstance);
    }

    public void displayAllEntries(ArrayList<Transaction> transactionData){
        for(int i = transactionData.size() - 1; i  >= 0; i--){
            System.out.println(transactionData.get(i).toString());
        }
    }

    public static void displayDeposits(ArrayList<Transaction> transactionData){

    }
}
