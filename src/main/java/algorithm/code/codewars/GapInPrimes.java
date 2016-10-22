package algorithm.code.codewars;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/22/16.
 */
public class GapInPrimes {

	public static long[] gap(int g, long m, long n) {
		// your code
		long first=-1;
		while(m<=n){
			if(isPrim(m)){
				if(first!=-1 && m-first==g) return new long[]{first,m};
				else first=m;
			}
			m++;
		}
		return null;
	}

	private static boolean isPrim(long m) {
		for(int i=2;i<=Math.sqrt(m);i++){
			if(m%i==0) return false;
		}
		return true;
	}

	@Test
	public void test() {
		System.out.println("Fixed Tests");
		assertEquals("[101, 103]", Arrays.toString(GapInPrimes.gap(2,100,110)));
		assertEquals("[103, 107]", Arrays.toString(GapInPrimes.gap(4,100,110)));
		assertEquals(null, GapInPrimes.gap(6,100,110));
		assertEquals("[359, 367]", Arrays.toString(GapInPrimes.gap(8,300,400)));
		assertEquals("[337, 347]", Arrays.toString(GapInPrimes.gap(10,300,400)));
	}
}
