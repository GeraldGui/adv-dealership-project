package com.pluralsight;

public abstract class Contract {
    String name = "";
    String date = "";
    String email = "";
    double vehicleSold = 0;
    double totalPrice = 0;
    double monthlyPayment = 0;

    public Contract(String name, String date, String email, double vehicleSold) {
        this.name = name;
        this.date = date;
        this.email = email;
        this.vehicleSold = vehicleSold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(double vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
