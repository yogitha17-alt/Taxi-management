package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import main.Customer;
import main.Vehicle;
import main.CherryCars;
import main.Electriccar;
import main.Nonelectriccar;
import main.Motorbike;

public class CherryCarsTest {
    private CherryCars cherryCars;
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    private Customer customer;

    @Before
    public void setUp() {
        cherryCars = new CherryCars();
        vehicle1 = new Nonelectriccar("Toyota", "Corolla", 2020, "ABC123", 4, "Diesel");
        vehicle2 = new Electriccar("Nissan", "Leaf", 2021, "XYZ789", 4, 120);
        customer = new Customer("123456");

        cherryCars.addVehicle(vehicle1);
    }

    

    @Test
    public void testBorrowVehicle() {
        assertTrue(cherryCars.borrowVehicle("ABC123", customer));
        assertFalse(cherryCars.borrowVehicle("ABC123", customer)); // Already rented
        assertFalse(cherryCars.borrowVehicle("QWE567", customer)); // Vehicle not added
    }

    @Test
    public void testCalculateCharge() {
        assertEquals(300.00, cherryCars.calculateCharge("ABC123", 3), 0.01);
    }

    @Test
    public void testFindVehicle() {
        assertEquals("ABC123", cherryCars.findVehicle("ABC123").getReg());
        assertNull(cherryCars.findVehicle("XYZ789")); // Vehicle not added
    }   

    @Test
    public void testGetVehicles() {
        cherryCars.addVehicle(vehicle2);
        ArrayList<Vehicle> vehicles = cherryCars.getVehicles();
        assertEquals(2, vehicles.size());
    }

    @Test
    public void testGetAvailableVehiclesByMake() {
        ArrayList<Vehicle> toyotaVehicles = cherryCars.getavailableVehiclesByMake("Toyota");
        assertEquals(1, toyotaVehicles.size());

    }

    @Test
    public void testReturnVehicle() {
        cherryCars.borrowVehicle("ABC123", customer);
        assertTrue(cherryCars.returnVehicle("ABC123", customer));
        assertFalse(cherryCars.returnVehicle("XYZ789", customer)); // Vehicle not rented/added

    }
}
