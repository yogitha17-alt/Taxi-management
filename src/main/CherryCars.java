package main;

import java.util.ArrayList;

public class CherryCars {
    private ArrayList<Vehicle> renting;

    public CherryCars() {
        renting = new ArrayList<>();

    }

    public boolean addVehicle(Vehicle vehicle) {
        Vehicle v = findVehicle(vehicle.getReg());
        if (v == null) {
            renting.add(vehicle);
            return true;
        }
        return false;
    }

    public ArrayList<Vehicle> getVehicles() {
        return renting;
    }

    public boolean borrowVehicle(String reg, Customer customer) {
        Vehicle v = findVehicle(reg);
        if (v != null && v.isAvailable()) {
            customer.rentVehicle(v);
            v.rentID(customer.getLicence());
            return true;
        }
        return false;

    }

    public Vehicle findVehicle(String reg) {
        for (Vehicle v : renting) {
            if (v.getReg().equalsIgnoreCase(reg)) {
                return v;
            }
        }
        return null;
    }

    public ArrayList<Vehicle> getavailableVehiclesByMake(String make) {
        ArrayList<Vehicle> makeVehicles = new ArrayList<>();
        for (Vehicle v : renting) {
            if (v.getMake().equalsIgnoreCase(make) && v.isAvailable()) {
                makeVehicles.add(v);
            }
        }
        return makeVehicles;
    }

    public boolean returnVehicle(String reg, Customer customer) {
        Vehicle v = findVehicle(reg);
        if (v != null && !v.isAvailable() && customer.getLicence().equalsIgnoreCase(v.getLicence())) {
            customer.returnVehicle(v);
            v.returnID("");

            return true;
        }
        return false;
    }

    public double calculateCharge(String reg, int daysRented) {
        Vehicle v = findVehicle(reg);
        if (v != null) {
            return v.calculateCharge(daysRented);
        }
        return 0.00;
    }

}
