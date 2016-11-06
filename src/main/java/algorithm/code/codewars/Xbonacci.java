package algorithm.code.codewars;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Xbonacci {

    public double[] tribonacci(double[] s, int n) {
//        if(n==0) return new double[0];
        double[] res = new double[n];
        for (int i = 0; i < Math.min(n, 3); i++) {
            res[i] = s[i];
        }
        if (n >=3) {
            for (int i = 3; i < n; i++) {
                res[i] = res[i - 1] + res[i - 2] + res[i - 3];
            }
        }
        return res;
    }

    private Xbonacci variabonacci;

    @Before
    public void setUp() throws Exception {
        variabonacci = new Xbonacci();
    }

    @After
    public void tearDown() throws Exception {
        variabonacci = null;
    }

    @Test
    public void basicTests() {
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, variabonacci.tribonacci(new double[]{1, 1, 1}, 10));
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, variabonacci.tribonacci(new double[]{0, 0, 1}, 10));
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, variabonacci.tribonacci(new double[]{0, 1, 1}, 10));
    }

    private void assertArrayEquals(double[] expecteds, double[] actuals) {
        for (int i = 0; i < actuals.length; i++)
            assertEquals(expecteds[i], actuals[i], 1e-10);
    }
}