import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LineTest {

    @Test
    public void testSlope() {
        Line l = new Line(1.0, 1.0, 4.0, 4.0);
        assertEquals(1.0, l.getSlope(), 0.0001);
        assertNotEquals(3.0, l.getSlope(), 0.0001);
    }

    @Test
    public void testDistance(){
        Line l = new Line(1.0, 1.0, 4.0, 4.0);
        assertEquals(4.2426, l.getDistance(), 0.0001);
        assertNotEquals(1.0, l.getDistance(), 0.0001);
    }

    @Test
    public void testParallel(){
        Line l = new Line(1.0, 1.0, 4.0, 4.0);

        assertEquals(true, l.parallelTo(new Line(1.0, 0.0, 5.0, 4.0)));
        assertNotEquals(false, l.parallelTo(new Line(4.0, 4.0, 2.0, 2.0)));

    }
        
}
