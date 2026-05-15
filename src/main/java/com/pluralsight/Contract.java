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

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getVehicleSold() {
        return vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
