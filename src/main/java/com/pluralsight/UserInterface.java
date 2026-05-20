package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void display() {
        init();
        boolean quit = false;
        while (!quit) {
            System.out.println("---------- Menu ----------");
            System.out.println("1. Get vehicles by price");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("3. Get vehicles by year");
            System.out.println("4. Get vehicles by color");
            System.out.println("5. Get vehicles by mileage");
            System.out.println("6. Get vehicles by type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("10. Sign a Contract for the Vehicle!");
            System.out.println("99. Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "10":
                    signingContract(scanner);
                    break;
                case "99":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int max = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int max = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
        System.out.print("Enter vehicle vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine();

        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();

        System.out.print("Enter vehicle year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();

        System.out.print("Enter vehicle mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle type (Car, Truck, SUV, Motorcycle): ");
        String type = scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);

        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Enter the VIN of the vehicle you wish to remove: ");
        int vin = scanner.nextInt();

        boolean vehicleRemoved = false;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle removed successfully!");
                vehicleRemoved = true;
                break;
            }
        }

        if (!vehicleRemoved) {
            System.out.println("Vehicle not found. Please try again.");
            return;
        }

        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        dealership = manager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    public void signingContract(Scanner scanner) {
        System.out.print("Would you like a Sale or Lease Contract? ");
        String typeOfContract = scanner.nextLine();

        if (typeOfContract.equalsIgnoreCase("sale")) {
            System.out.print("Provide the vin for the car you want to sale: ");
            int vinSale = scanner.nextInt();
            scanner.nextLine();

            Vehicle vehicles = dealership.getAllVehicles().stream().filter(vehicle -> vehicle.getVin() == vinSale).findFirst().orElse(null);

            System.out.print("Provide your name: ");
            String name = scanner.nextLine();

            System.out.print("Provide the date: ");
            String date = scanner.nextLine();

            System.out.print("Provide your email: ");
            String email = scanner.nextLine();

            SalesContract salesContract = new SalesContract(name, date, email, vehicles);

            ContractDataManager contractDataManager = new ContractDataManager();

            StringBuilder sb = new StringBuilder();
            System.out.println("\n========== Sales Contract ==========\n");
            sb.append("Date: ").append(date).append("\n");
            sb.append("Name: ").append(name).append("\n");
            sb.append("Email: ").append(email).append("\n");
            sb.append("Vehicle: ").append(vehicles.getYear()).append(" ").append(vehicles.getMake()).append(" ").append(vehicles.getModel()).append("\n");
            sb.append("VIN: ").append(vehicles.getVin()).append("\n");
            sb.append("Price: $").append(String.format("%.2f", vehicles.getPrice())).append("\n");
            sb.append("Sale Tax: $").append(String.format("%.2f", salesContract.getSaleTax())).append("\n");
            sb.append("Recording Fee: $").append(salesContract.getRecordingFee()).append("\n");
            sb.append("Processing Fee: $").append(salesContract.getProcessingFee()).append("\n");
            sb.append("Total Price: $").append(String.format("%.2f", salesContract.getTotalPrice())).append("\n");
            System.out.println(sb);
            System.out.println("====================================");

            System.out.print("Would you like to finance? (yes/no): ");
            String financeAnswer = scanner.nextLine();
            salesContract.setGoingToFinance(financeAnswer.equalsIgnoreCase("yes"));


            String sb2 = "\n========== Final Sales Contract ==========\n\n" +
                    sb +
                    "Monthly Payment: $" + String.format("%.2f", salesContract.getMonthlyPayment()) + "\n" +
                    "\n====================================";
            System.out.println(sb2);

            System.out.print("Confirm contract? (yes/no): ");
            String confirm = scanner.nextLine();
            if (!confirm.equalsIgnoreCase("yes")) {
                System.out.println("Contract cancelled.");
                salesContract.setGoingToFinance(false);
                contractDataManager.saveContract(salesContract);
                return;
            } else {
                salesContract.setGoingToFinance(true);
            }

            contractDataManager.saveContract(salesContract);
            dealership.removeVehicle(vehicles);
            DealershipFileManager manager = new DealershipFileManager();
            manager.saveDealership(dealership);

        } else if (typeOfContract.equalsIgnoreCase("lease")) {
            System.out.print("Provide the vin for the car you want to lease: ");
            int vinLease = scanner.nextInt();
            scanner.nextLine();

            Vehicle vehicles =  dealership.getAllVehicles().stream().filter(vehicle -> vehicle.getVin() == vinLease).findFirst().orElse(null);

            if (vehicles == null) {
                System.out.println("Vehicle not found.");
                return;
            }

            if (vehicles.getYear() < 2023) {
                System.out.println("Sorry, you cannot lease a vehicle over 3 years old.");
                return;
            }

            System.out.print("Provide your name: ");
            String name = scanner.nextLine();

            System.out.print("Provide the date: ");
            String date = scanner.nextLine();

            System.out.print("Provide your email: ");
            String email = scanner.nextLine();

            LeaseContract leaseContract = new LeaseContract(name, date, email, vehicles);

            ContractDataManager contractDataManager = new ContractDataManager();

            contractDataManager.saveContract(leaseContract);
            dealership.removeVehicle(vehicles);
            DealershipFileManager manager = new DealershipFileManager();
            manager.saveDealership(dealership);
        }
    }
}