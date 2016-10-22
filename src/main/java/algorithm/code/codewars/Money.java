package algorithm.code.codewars;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/22/16.
 */
public class Money {
	public static int calculateYears(double principal, double interest,  double tax, double desired) {
		// your code
		int year=0;
		double money=principal;
		while(money<desired){
			money+=money*interest*(1-tax);
			year++;
		}
		return year;
	}


	@Test
	public void test() {
		System.out.println("Fixed Tests calculateYears");
		assertEquals(3, Money.calculateYears(1000,0.05,0.18,1100));
		assertEquals(14 , Money.calculateYears(1000,0.01625,0.18,1200));
		assertEquals(0, Money.calculateYears(1000,0.05,0.18,1000));
	}
}
