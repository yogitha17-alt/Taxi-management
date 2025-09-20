package main;

public class Nonelectriccar extends Car{
    private String fueltype;

    public Nonelectriccar(String make, String model, int year, String reg, int doors, String fueltype) {
        super(make, model, year, reg, doors);
        this.fueltype = fueltype;
    }

    public String getFueltype() {
        return fueltype;
    }

    @Override
    public String toString() {
        return super.toString() + ", fueltype = " + fueltype;
    }

    @Override
    public double calculateCharge(int rentedDays){
        return rentedDays * 100;
    }
}
