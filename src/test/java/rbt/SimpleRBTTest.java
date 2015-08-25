package rbt;

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
}
