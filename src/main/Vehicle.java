package main;

public abstract class Vehicle {
    protected String make;
    protected String model;
    protected String reg;
    protected int year;
    private String licence;

    public Vehicle(String make, String model, int year, String reg) {
        this.make = make;
        this.model = model;
        this.reg = reg;
        this.year = year;
        this.licence = "";
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getReg() {
        return reg;
    }

    @Override
    public String toString() {
        return (isAvailable() ? "Available" : "Not available") + ": make = " + make + ", model = " + model + ", year = " + year + ", reg = " + reg;
    }

    public abstract double calculateCharge(int rentedDays);

    public boolean isAvailable() {
        return licence.isEmpty();
    }

    public void rentID(String licence) {
        this.licence = licence;
    }
    
    public void returnID(String licence) {
        this.licence = "";
    }

    public String getLicence() {
        return licence;
    }
}
