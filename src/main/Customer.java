package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String licenceNumber;
    private ArrayList<Vehicle> rentList;
    private ArrayList<Vehicle> returnList;

    public Customer(String licenceNumber) {
        this.licenceNumber = licenceNumber;
        this.rentList = new ArrayList<>();
        this.returnList = new ArrayList<>();
    }

    public void setLicence(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getLicence() {
        return licenceNumber;
    }

    public void rentVehicle(Vehicle vehicle) {
        if (vehicle.isAvailable()) {
            vehicle.rentID(licenceNumber);
            rentList.add(vehicle);
        }
    }

    public void returnVehicle(Vehicle vehicle) {
        if (rentList.remove(vehicle)) {
            vehicle.returnID(licenceNumber);
            returnList.add(vehicle);
        }
    }

    public ArrayList<Vehicle> getRentedVehicles() {
        return rentList;
    }

    public ArrayList<Vehicle> getReturnedVehicles() {
        return returnList;
    }
}
