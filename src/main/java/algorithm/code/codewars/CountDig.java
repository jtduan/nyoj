package algorithm.code.codewars;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/22/16.
 */
public class CountDig {

	public static int nbDig(int n, int d) {
		int res=0;
		for(int i=1;i<=n;i++){
			res+=hasNumber(i*i,d);
		}
		if(d==0) return res+1;
		return res;
	}

	private static int hasNumber(long n, int d) {
		int res=0;
		while(n!=0){
			if(n%10 == d)res++;
			n=n/10;
		}
		return res;
	}


	private static void testing(int actual, int expected) {
		assertEquals(expected, actual);
	}
	@Test
	public void test() {
		System.out.println("Fixed Tests nbDig");
		testing(CountDig.nbDig(5750, 0), 4700);
		testing(CountDig.nbDig(11011, 2), 9481);
		testing(CountDig.nbDig(12224, 8), 7733);
		testing(CountDig.nbDig(11549, 1), 11905);
	}
}
