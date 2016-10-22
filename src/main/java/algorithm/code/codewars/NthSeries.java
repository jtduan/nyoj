package algorithm.code.codewars;

import org.junit.Test;

import java.text.NumberFormat;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/22/16.
 */
public class NthSeries {

	public static String seriesSum(int n) {
		// Happy Coding ^_^
		double sum=0;
		for(int i=1;i<=n;i++){
			sum+=1/(double)(3*i-2);
		}
		NumberFormat ddf1=NumberFormat.getNumberInstance();
		ddf1.setMaximumFractionDigits(2);
		ddf1.setMinimumFractionDigits(2);

		return ddf1.format(sum);
	}

	@Test
	public void test1() {
		assertEquals(NthSeries.seriesSum(5), "1.57");
	}
	@Test
	public void test2() {
		assertEquals(NthSeries.seriesSum(9), "1.77");
	}
	@Test
	public void test3() {
		assertEquals(NthSeries.seriesSum(15), "1.94");
	}
}