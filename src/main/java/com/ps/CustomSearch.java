package com.ps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;


public class CustomSearch {

    private static final String DATE_FORMAT = "yyyy-MM-dd";


    public static ArrayList<Transaction> searchStartDate(ArrayList<Transaction> transactionData, String startDate) {
        ArrayList<Transaction> filteredList = new ArrayList<>();
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate compare_startDate = LocalDate.parse(startDate, DATE_FORMATTER);
        for (int i = 0; i < transactionData.size(); i++) {
            LocalDate localDate = LocalDate.parse(transactionData.get(i).getDate());
            if (localDate.isAfter(compare_startDate)) {
                filteredList.add(transactionData.get(i));
            }
        }
        return filteredList;
    }

    public static ArrayList<Transaction> searchEndDate(ArrayList<Transaction> transactionData, String endDate) {
        ArrayList<Transaction> filteredList = new ArrayList<>();
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate compare_endDate = LocalDate.parse(endDate, DATE_FORMATTER);
        for (int i = 0; i < transactionData.size(); i++) {
            LocalDate localDate = LocalDate.parse(transactionData.get(i).getDate());
            if (localDate.isBefore(compare_endDate)) {
                filteredList.add(transactionData.get(i));
            }

        }
        return filteredList;
    }

        public static ArrayList<Transaction> searchVendor(ArrayList < Transaction > transactionData, String vendor){
            ArrayList<Transaction> filteredList = new ArrayList<>();
            for (int i = 0; i < transactionData.size(); i++) {
                if (transactionData.get(i).getVendor().toLowerCase().contains(vendor.toLowerCase())) {
                    filteredList.add(transactionData.get(i));
                }
            }
            return filteredList;
        }

        public static ArrayList<Transaction> searchDescription (ArrayList < Transaction > transactionData, String description){
            ArrayList<Transaction> filteredList = new ArrayList<>();
            for(int i = 0; i < transactionData.size(); i++) {
                if (transactionData.get(i).getDescription().toLowerCase().contains(description.toLowerCase())) {
                    filteredList.add(transactionData.get(i));
                }
            }
            return filteredList;
        }

        public static ArrayList<Transaction> searchAmount(ArrayList < Transaction > transactionData,float amount){

            ArrayList<Transaction> filteredList = new ArrayList<>();
            for (int i = 0; i < transactionData.size(); i++) {
                if (transactionData.get(i).getAmount() >= amount) {
                    filteredList.add(transactionData.get(i));
                }
            }
            return filteredList;
        }


    }


