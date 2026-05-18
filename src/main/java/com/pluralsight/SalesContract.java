package com.pluralsight;

import java.time.LocalDate;

public class SalesContract extends Contract {
    private double saleTax;
    private int recordingFee = 100;
    private int processingFee;
    private boolean goingToFinance;

    public SalesContract(String name, String date, String email, Vehicle vehicleSold) {
        super(name, date, email, vehicleSold);
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getSaleTax() {
        saleTax = getVehicleSold().getPrice() * 0.05;
        return saleTax;
    }

    public void setSaleTax(double saleTax) {
        this.saleTax = saleTax;
    }

    public int getProcessingFee() {
        if (vehicleSold.getPrice() < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }
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
        return getVehicleSold().getPrice() + getSaleTax() + recordingFee + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (goingToFinance) {
            if (getVehicleSold().getPrice() >= 10000) {
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
