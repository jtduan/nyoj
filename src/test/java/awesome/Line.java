import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/22/16.
 */
public class Line {
	public static String Tickets(int[] peopleInLine) {

		int[] nums = new int[2];
		for (int i = 0; i < peopleInLine.length; i++) {
			if (peopleInLine[i] == 25) nums[0]++;
			else if (peopleInLine[i] == 50) {
				nums[1]++;
				nums[0]--;
			} else if (peopleInLine[i] == 100) {
				nums[1]--;
				nums[0]--;
			}
			if(!check(nums)) return "NO";
		}
		return "YES";
	}

	private static boolean check(int[] nums) {
		while(nums[1]<0){
			nums[1]++;
			nums[0]-=2;
		}
		if(nums[0]<0) return false;
		return true;
	}


	@Test
	public void test1() {
		assertEquals("YES", Line.Tickets(new int[] {25, 25, 50}));
	}
	@Test
	public void test2() {
		assertEquals("NO", Line.Tickets(new int []{25, 100}));
	}
}
