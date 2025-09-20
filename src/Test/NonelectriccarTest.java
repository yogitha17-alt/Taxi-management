package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.Nonelectriccar;

public class NonelectriccarTest {
    @Test
    public void TestNonelectriccar() {
        Nonelectriccar n1 = new Nonelectriccar("porshe", "911 GT3", 2024, "HJ4 HGF", 4, "Petrol");
        assertEquals("porshe", n1.getMake());
        assertEquals("911 GT3", n1.getModel());
        assertEquals(2024, n1.getYear());
        assertEquals("HJ4 HGF", n1.getReg());
        assertEquals(4, n1.getDoors());
        assertEquals("Petrol", n1.getFueltype());
        assertEquals(400.0, n1.calculateCharge(4),0);
        assertEquals("Available: make = porshe, model = 911 GT3, year = 2024, reg = HJ4 HGF, doors = 4, fueltype = Petrol", n1.toString());
    }
}
