package com.pluralsight;

import java.time.LocalDate;
import java.util.List;

public abstract class Contract {
    String name = "";
    String date;
    String email = "";
    Vehicle vehicleSold;
    double totalPrice = 0;
    double monthlyPayment = 0;

    public Contract(String name, String date, String email, Vehicle vehicleSold) {
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

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
