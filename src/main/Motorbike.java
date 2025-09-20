package main;

public class Motorbike extends Vehicle{
    private boolean sidecar;

    public Motorbike(String make, String model, int year, String reg, boolean sidecar) {
        super(make, model, year, reg);
        this.sidecar = sidecar;
    }

    public boolean getSidecar() {
        return sidecar;
    }

    @Override
    public String toString() {
        return super.toString() + ", sidecar = " +sidecar;
    }

    @Override
    public double calculateCharge(int rentedDays) {
        return rentedDays * 150;
    }
}
