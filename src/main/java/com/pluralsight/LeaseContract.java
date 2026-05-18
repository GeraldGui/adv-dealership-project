package com.pluralsight;

import java.time.LocalDate;

public class LeaseContract extends Contract {
    private double endingValue;
    private double leaseFee;

    public LeaseContract(String name, String date, String email, Vehicle vehicleSold) {
        super(name, date, email, vehicleSold);
        endingValue = vehicleSold.getPrice() * 0.50;
        leaseFee = vehicleSold.getPrice() * 0.07;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return (getVehicleSold().getPrice() - getEndingValue()) + getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }
}
