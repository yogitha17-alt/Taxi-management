package main;

public class Electriccar extends Car{
    private int miles;

    public Electriccar(String make, String model, int year, String reg, int doors, int miles) {
        super(make, model, year, reg, doors);
        this.miles = miles;
    }

    public int getMiles() {
        return miles;
    }

    @Override
    public String toString() {
        return super.toString()+ ", miles = " + miles;
    }

    @Override
    public double calculateCharge(int rentedDays){
        return rentedDays * 120;
    }
}
