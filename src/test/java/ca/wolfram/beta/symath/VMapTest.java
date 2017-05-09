package ca.wolfram.beta.symath;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Allan Wang on 2017-05-09.
 */
public class VMapTest {

    private VMap map;

    @Before
    public void init() {
        map = new VMap();
    }

    @Test
    public void put() {
        map.put("PI", Math.PI);
        map.put("PI", Math.PI, true); //exception should not be thrown
        try {
            map.put("PI", 3.14, true);
            fail("PI cannot be remapped to a different double");
        } catch (Exception e) {
            //error was thrown
        }
        assertEquals("PI should have value of Math.PI", Math.PI, map.get("PI"), 0.0001);
    }

    @Test
    public void get() {
        map.put("PI", Math.PI);
        assertEquals("PI should have value of Math.PI", Math.PI, map.get("PI"), 0.0001);
    }

    @Test
    public void getWithDefault() {
        assertEquals("a should == 3", 3, map.get("a", 3), 0.0001);
    }

    @Test
    public void getWithError() {
        try {
            map.get("a", "var not defined");
            fail("a was not defined");
        } catch (Exception e) {
            //error caught
        }
    }
}
