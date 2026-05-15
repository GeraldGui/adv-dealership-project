package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double monthlyPayment;
    private int recordingFee = 100;
    private int processingFee;
    private String goingToFinance;

    public SalesContract(String name, String date, String email, double vehicleSold) {
        super(name, date, email, vehicleSold);
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }


    public int getRecordingFee() {
        return recordingFee;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public String getGoingToFinance() {
        return goingToFinance;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

}
