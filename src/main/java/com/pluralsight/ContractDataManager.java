package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    public void saveContract(Contract contract) {
        if (contract instanceof SalesContract salesContract) {
            try {
                BufferedWriter bufferedWriter = getBufferedWriter(String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                        contract.date, contract.name, contract.email,
                        contract.vehicleSold.getVin(), contract.vehicleSold.getYear(),
                        contract.vehicleSold.getMake(), contract.vehicleSold.getModel(),
                        contract.vehicleSold.getVehicleType(), contract.vehicleSold.getColor(),
                        contract.vehicleSold.getOdometer(), contract.vehicleSold.getPrice(),
                        salesContract.getSaleTax(), (double) salesContract.getRecordingFee(),
                        (double) salesContract.getProcessingFee(), salesContract.getTotalPrice(),
                        salesContract.isGoingToFinance() ? "YES" : "NO", salesContract.getMonthlyPayment()));
                System.out.println("You have completed your Sales Contract!");
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Error saving Sales Contract!");
            }
        } else if (contract instanceof LeaseContract leaseContract) {
                try {
                    BufferedWriter bufferedWriter = getBufferedWriter(String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f",
                            contract.date, contract.name, contract.email,
                            contract.vehicleSold.getVin(), contract.vehicleSold.getYear(),
                            contract.vehicleSold.getMake(), contract.vehicleSold.getModel(),
                            contract.vehicleSold.getVehicleType(), contract.vehicleSold.getColor(),
                            contract.vehicleSold.getOdometer(), contract.vehicleSold.getPrice(),
                            leaseContract.getEndingValue(), leaseContract.getLeaseFee(),
                            leaseContract.totalPrice, leaseContract.getMonthlyPayment()));
                    System.out.println("You have completed your Lease Contract!");
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Error saving Sales Contract!");
                }

        } else {
            System.out.println("Contract has problems being saved!");
        }
    }

    private static BufferedWriter getBufferedWriter(String date) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contracts.csv", true));
        bufferedWriter.write(date);
        return bufferedWriter;
    }
}
