package rbt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RBTTest {

    private int size;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2}, {3}, {5}, {10}, {20}, {100}, {1000}, {10000}
        });
    }

    public RBTTest(int size) {
        this.size = size;
    }

    @Test(timeout = 1000)
    public void complexityTest() {
        RBT rbt = new RBT();
        StringBuilder msg = new StringBuilder()
                .append("RBT(")
                .append(size)
                .append(")\t");
        for (Integer i = 0; i <= size; i++) {
            rbt.put(i,2*i);
        }
        msg.append("put(1,2)..put(")
                .append(size)
                .append(",")
                .append(size * 2)
                .append(")\t");
        for (Integer i = size; i > 0; i--) {
            msg.append("get(")
                    .append(i)
                    .append("), ");
            assertEquals(msg.toString(), (Integer)(2 * i), (Integer)rbt.get(i));
        }
    }
}
