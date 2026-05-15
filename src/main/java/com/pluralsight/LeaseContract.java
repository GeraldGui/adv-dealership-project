package com.pluralsight;

public class LeaseContract extends Contract {
    private double endingValue;
    private double leaseFee;
    private double monthlyPayemnt;

    public LeaseContract(String name, String date, String email, double vehicleSold) {
        super(name, date, email, vehicleSold);
    }

    public double getEndingValue() {
        return endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public double getMonthlyPayemnt() {
        return monthlyPayemnt;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
