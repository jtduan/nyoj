package algorithm.code.codewars;

import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/23/16.
 */
public class Fibonacci {

	public static BigInteger fib(BigInteger n) {

		BigInteger first=BigInteger.ZERO;
		BigInteger second=BigInteger.ONE;
		if(n.equals(BigInteger.ZERO)) return first;
		if(n.equals(BigInteger.ONE)) return second;

		if(n.compareTo(BigInteger.ZERO)<0){
			BigInteger cur=BigInteger.valueOf(-1);
			while(cur.compareTo(n)>=0){
				BigInteger temp = second;
				second =first;
				first=temp.subtract(second);
				cur=cur.subtract(BigInteger.ONE);
			}
			return first;
		}
		else {
			BigInteger cur = BigInteger.valueOf(2);
			while (cur.compareTo(n) <= 0) {
				BigInteger temp = first;
				first = second;
				second = first.add(temp);
				cur = cur.add(BigInteger.ONE);
			}
			return second;
		}
	}

	public void fib(){

	}

	@Test
	public void testFib0() {
		testFib(0, 0);
	}

	@Test
	public void testFib1() {
		testFib(1, 1);
	}

	@Test
	public void testFib2() {
		testFib(1, 2);
	}

	@Test
	public void testFib3() {
		testFib(-8, -6);
	}

	@Test
	public void testFib4() {
		testFib(3, 4);
	}

	@Test
	public void testFib5() {
		testFib(5, 5);
	}

	private static void testFib(long expected, long input) {
		BigInteger found;
		try {
			found = Fibonacci.fib(BigInteger.valueOf(input));
		}
		catch (Throwable e) {
			// see https://github.com/Codewars/codwars.com/issues/21
			throw new AssertionError("exception during test: "+e, e);
		}
		assertEquals(BigInteger.valueOf(expected), found);
	}
}