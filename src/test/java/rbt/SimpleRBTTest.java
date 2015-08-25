package rbt;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SimpleRBTTest {

    @Test
    public void deletion() {
        RBT rbt = new RBT();
        rbt.put(1,1);
        rbt.put(2,2);
        rbt.remove(2);
        Comparable expected = null;
        Comparable actual = rbt.get(2);
        assertEquals(expected,actual);
        expected = 1;
        actual = rbt.get(1);
        assertEquals(expected,actual);
    }

    @Test
    public void deletion5() {
        RBT rbt = new RBT();
        rbt.put(1,1);
        rbt.put(2,2);
        rbt.put(3,3);
        rbt.put(4,4);
        rbt.put(5,5);
        rbt.remove(5);
        rbt.remove(4);
        rbt.remove(3);
        rbt.remove(2);
        Comparable expected = null;
        Comparable actual = rbt.get(2);
        assertEquals(expected,actual);
    }
}
