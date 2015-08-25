package rbt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RBTDeletionTest {

    private int size;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2}, {3}, {5}, {10}, {20}, {100}, {1000}, {10000}
        });
    }

    public RBTDeletionTest(int size) {
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
        for (Integer i = size; i >= 0; i--) {
            msg.append("remove(")
                    .append(i)
                    .append("), ");
            msg.append("get(")
                    .append(i)
                    .append("), ");
            rbt.remove(i);
            assertEquals(msg.toString(), null, (Integer)rbt.get(i));
        }
    }
}
