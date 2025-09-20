package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static CherryCars cherryCars = new CherryCars();
    private static Customer customer1 = new Customer("123ABC");
    private static Scanner kybd = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        populateVehicles();
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            processChoice(choice);
        } while (choice != -1);
        kybd.close();

    }

    public static void populateVehicles() {
        // cherryCars.addVehicle(new Electriccar("Tesla", "Model 3", 2022, "AA11 AAA",
        // 4, 320));
        // cherryCars.addVehicle(new Electriccar("Nissan", "Leaf", 2021, "BB22 BBB", 4,
        // 220));
        // cherryCars.addVehicle(new Electriccar("BMW", "i4", 2023, "CC33 CCC", 4,
        // 300));
        // cherryCars.addVehicle(new Nonelectriccar("Ford", "Focus", 2019, "DD44 DDD",
        // 4, "Petrol"));
        // cherryCars.addVehicle(new Nonelectriccar("Ford", "Escort", 2020, "EE55 EEE",
        // 4, "Petrol"));
        // cherryCars.addVehicle(new Nonelectriccar("Volkswagen", "Golf", 2020, "FF66
        // FFF", 4, "Diesel"));
        // cherryCars.addVehicle(new Nonelectriccar("Audi", "A4", 2018, "GG77 GGG", 4,
        // "Petrol"));
        // cherryCars.addVehicle(new Motorbike("Yamaha", "R1", 2021, "HH88 HHH",
        // false));
        // cherryCars.addVehicle(new Motorbike("Harley-Davidson", "Street Glide", 2020,
        // "II99 III", true));
        // cherryCars.addVehicle(new Motorbike("Kawasaki", "Ninja 250", 2022, "JJ00
        // JJJ", false));
        // cherryCars.addVehicle(new Electriccar("Duplicate", "Duplicate", 2022, "AA11
        // AAA", 4, 320));

        ArrayList<Vehicle> vehicle = DatabaseHelper.fetchVehicle();

        int x = 0;

        for (Vehicle v : vehicle) {

            x++;

            if (v != null) {

                if (cherryCars.findVehicle(v.getMake()) == null) {

                    cherryCars.addVehicle(v);

                } else {

                    System.out.println(v.getMake() + " is a duplicate so not added");

                }

            } else {

                System.out.println("There is a problem with the database structure when adding record " + x);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Cherry cars Menu");
        // System.out.println("1. Add a vehicle");
        System.out.println("1. View all vehicles");
        System.out.println("2. Get available vehicles by make");
        System.out.println("3. Rent a vehicle");
        System.out.println("4. Return a vehicle");
        System.out.println("5. View returned vehicles");
        System.out.println("6. View renting vehicles");
        System.out.println("7. calculate charge");
        System.out.println("-1. exit");
        System.out.println("Enter your choice: ");
    }

    private static int getUserChoice() {
        int choice = kybd.nextInt();
        kybd.nextLine();
        return choice;
    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                viewAllVehicles();
                break;
            case 2:
                getavailableVehiclesByMake();
                break;
            case 3:
                borrowVehicle();
                break;
            case 4:
                returnVehicle();
                break;
            case 5:
                viewReturnedVehicles();
                break;
            case 6:
                viewRentingVehicles();
                break;
            case 7:
                calculateCharge();
                break;
            case -1:
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Invalid choice, please choose between 1 and 7");
        }
    }

    private static void borrowVehicle() {
        System.out.println("Enter registration number to rent: ");
        String reg = kybd.nextLine();

        if (cherryCars.borrowVehicle(reg, customer1)) {
            System.out.println(reg + " rented successfully");
        } else {
            System.out.println(reg + " doesn't exist or already rented");

        }
    }

    private static void returnVehicle() {
        System.out.println("Enter registration number to return: ");
        String reg = kybd.nextLine();

        if (cherryCars.returnVehicle(reg, customer1)) {
            System.out.println(reg + " returned successfully");
        } else {
            System.out.println(reg + " doesn't exist or not rented");
        }
    }

    private static void getavailableVehiclesByMake() {
        try {
            System.out.println("Enter make: ");
            String make = kybd.nextLine();
            ArrayList<Vehicle> makeVehicles = cherryCars.getavailableVehiclesByMake(make);
            if (makeVehicles.isEmpty()) {
                System.out.println("No available vehicles by " + make + " in the cherrycars");
            } else {
                System.out.println(" available Vehicles by " + make + ":");
                for (Vehicle v : makeVehicles) {
                    System.out.println(v.toString());
                }

            }
        } catch (Exception e) {
            System.out.println("An error occurred while fetching available vehicles: " + e.getMessage());
        }
    }

    private static void viewRentingVehicles() {
        ArrayList<Vehicle> renting = customer1.getRentedVehicles();
        if (renting.isEmpty()) {
            System.out.println("No vehicles are rented");
        } else {
            System.out.println("Renting vehicles");
            for (Vehicle v : renting) {
                System.out.println(v.toString());
            }
        }
    }

    private static void viewReturnedVehicles() {
        ArrayList<Vehicle> returnedVehicles = customer1.getReturnedVehicles();
        if (returnedVehicles.isEmpty()) {
            System.out.println("No vehicles are returned");
        } else {
            System.out.println("Vehicles returned");
            for (Vehicle v : returnedVehicles) {
                System.out.println(v.toString());
            }
        }
    }

    private static void viewAllVehicles() {
        ArrayList<Vehicle> allVehicles = cherryCars.getVehicles();
        if (allVehicles.isEmpty()) {
            System.out.println("No vehicles in the system");
        } else {
            System.out.println("All Vehicles ");
            for (Vehicle v : allVehicles) {
                System.out.println(v.toString());
            }
        }
    }

    private static void calculateCharge() {
        try {
            System.out.print("Enter the reg to calculate the cost: ");
            String reg = kybd.nextLine();

            System.out.print("Enter the number of renting days: ");
            int days = getUserChoice();

            double charge = cherryCars.calculateCharge(reg, days);

            System.out.println("total cost is : £ " + String.format("%.2f", charge));
            System.out.println();
        } catch (Exception e) {
            System.out.println("An error occurred while calculating vehicles: " + e.getMessage());
        }
    }

}
