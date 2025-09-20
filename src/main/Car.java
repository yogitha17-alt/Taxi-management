package main;

public abstract class Car extends Vehicle {
    protected int doors;
    

    public Car(String make, String model, int year, String reg, int doors) {
        super(make, model, year, reg);
        this.doors = doors;
        
    }

    public int getDoors() {
        return doors;
    }

    
    @Override
    public String toString() {
        return super.toString() + ", doors = " + doors ;
    }

    
}
