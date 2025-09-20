package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.Motorbike;

public class MotorbikeTest {
    @Test
    public void TestMotorbike() {
        Motorbike m1 = new Motorbike("KTM", "Duke 250", 2012, "GH6 HJD", false);
        assertEquals("KTM", m1.getMake());
        assertEquals("Duke 250", m1.getModel());
        assertEquals(2012, m1.getYear());
        assertEquals("GH6 HJD", m1.getReg());
        assertEquals(false, m1.getSidecar());
        assertEquals(300.0, m1.calculateCharge(2),0);
        assertEquals("Available: make = KTM, model = Duke 250, year = 2012, reg = GH6 HJD, sidecar = false", m1.toString());
    }
    
}
