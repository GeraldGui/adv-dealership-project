package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTaxAmount = .95;
    private double monthlyPayment;
    private int recordingFee = 100;
    private int processingFee;
    private boolean goingToFinance;

    public SalesContract(String name, String date, String email, double vehicleSold) {
        super(name, date, email, vehicleSold);
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isGoingToFinance() {
        return goingToFinance;
    }

    public void setGoingToFinance(boolean goingToFinance) {
        this.goingToFinance = goingToFinance;
    }

    @Override
    public double getTotalPrice() {
        return getVehicleSold() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (goingToFinance) {
            if (getVehicleSold() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }
}
