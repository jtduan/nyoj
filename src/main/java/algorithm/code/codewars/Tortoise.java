package algorithm.code.codewars;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by djt on 10/22/16.
 */
public class Tortoise {
	public static int[] race(int v1, int v2, int g) {
		// your code
		if(v1>=v2) return null;
		double seconds = g*3600/((double)v2-(double)v1);
		return convert(seconds);
	}

	private static int[] convert(double seconds) {
		int[] res = new int[3];
		res[0]=(int)seconds/3600;
		res[1]=(int)(seconds%3600)/60;
		res[2]=(int)seconds%60;
		return res;
	}

	@Test
	public void test1() {
		System.out.println("Basic Tests");
		assertArrayEquals(new int[]{0, 32, 18}, Tortoise.race(720, 850, 70));
		assertArrayEquals(new int[]{3, 21, 49}, Tortoise.race(80, 91, 37));
		assertArrayEquals(new int[]{2, 0, 0}, Tortoise.race(80, 100, 40));
	}
}
