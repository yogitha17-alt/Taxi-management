package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.Electriccar;

public class ElectriccarTest {
    @Test
    public void testElectriccar() {
        Electriccar e1 = new Electriccar("Tesla", "Model 3", 2023, "AV6 MKJ", 4, 200);
        assertEquals("Tesla", e1.getMake());
        assertEquals("Model 3", e1.getModel());
        assertEquals(2023, e1.getYear());
        assertEquals("AV6 MKJ", e1.getReg());
        assertEquals(4, e1.getDoors());
        assertEquals(200, e1.getMiles());
        assertEquals(360.0, e1.calculateCharge(3), 0);
        assertEquals("Available: make = Tesla, model = Model 3, year = 2023, reg = AV6 MKJ, doors = 4, miles = 200", e1.toString());
    }
}
