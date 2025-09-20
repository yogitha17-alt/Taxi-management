package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Customer;
import main.Electriccar;
import main.Vehicle;

public class CustomerTest {
    private Customer c;
    private Electriccar e;

    @Before
    public void setUp() {
        c = new Customer("678698ABCD");
        e = new Electriccar("Mercedes", "C200", 2021, "HJ4 HGF", 4, 200);

    }

    @Test
    public void testGetLicence() {
        assertEquals("678698ABCD", c.getLicence());
    }

    @Test
    public void testSetLicence() {
        c.setLicence("123456XYZ");
        assertEquals("123456XYZ", c.getLicence());
    }

    @Test
    public void testRentVehicle() {
        c.rentVehicle(e);
        assertTrue(c.getRentedVehicles().contains(e));
        assertEquals("678698ABCD", e.getLicence());
    }

    @Test
    public void testReturnVehicle() {
        c.rentVehicle(e);
        c.returnVehicle(e);
        assertTrue(c.getReturnedVehicles().contains(e));
        assertFalse(c.getRentedVehicles().contains(e));
        assertEquals("", e.getLicence());
    }

    @Test
    public void testGetRentedVehicles() {
        c.rentVehicle(e);
        ArrayList<Vehicle> rentedVehicles = c.getRentedVehicles();
        assertEquals(1, rentedVehicles.size());
        assertTrue(rentedVehicles.contains(e));
    }

    @Test
    public void testGetReturnedVehicles() {
        c.rentVehicle(e);
        c.returnVehicle(e);
        ArrayList<Vehicle> returnedVehicles = c.getReturnedVehicles();
        assertEquals(1, returnedVehicles.size());
        assertTrue(returnedVehicles.contains(e));
    }
}
