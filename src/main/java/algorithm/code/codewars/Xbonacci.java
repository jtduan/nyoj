package algorithm.code.codewars;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by djt on 10/23/16.
 */
public class Xbonacci {

	public double[] xbonacci(double[] signature, int n) {
		double res[] = new double[n];
		for (int i = 0; i < Math.min(signature.length, n); i++) {
			res[i] = signature[i];
		}
		for (int i = signature.length; i < n; i++) {
			double sum = 0;
			for (int j = i - signature.length; j < i; j++) {
				sum += res[j];
			}
			res[i] = sum;
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
		assertArrayEquals(new double[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, variabonacci.xbonacci(new double[]{0, 1}, 10));
		assertArrayEquals(new double[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55}, variabonacci.xbonacci(new double[]{1, 1}, 10));
		assertArrayEquals(new double[]{0, 0, 0, 0, 1, 1, 2, 4, 8, 16}, variabonacci.xbonacci(new double[]{0, 0, 0, 0, 1}, 10));
		assertArrayEquals(new double[]{1, 0, 0, 0, 0, 0, 1, 2, 3, 6}, variabonacci.xbonacci(new double[]{1, 0, 0, 0, 0, 0, 1}, 10));
	}

	private void assertArrayEquals(double[] expecteds, double[] actuals) {
		for (int i = 0; i < actuals.length; i++)
			assertEquals(expecteds[i], actuals[i], 1e-10);
	}
}
