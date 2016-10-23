package algorithm.code.codewars;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/23/16.
 */
public class Tour {

	public static int tour(String[] arrFriends, String[][] ftwns, Map<String, Double> h) {
		Map<String, Double> map = new HashMap<>();
		for (int i = 0; i < ftwns.length; i++) {
			map.put(ftwns[i][0], h.get(ftwns[i][1]));
		}
		Double sum = map.get(arrFriends[0]);
		for (int i = 1; i < arrFriends.length; i++) {
			Double line = map.get(arrFriends[i - 1]);
			Double newline = map.get(arrFriends[i]);
			if (newline == null) return (int) (sum + line);
			sum += Math.sqrt(newline * newline - line * line);
		}
		return (int) (sum + map.get(arrFriends[arrFriends.length - 1]));
	}


	@Test
	public void test1() {
		String[] friends1 = new String[]{"A1", "A2", "A3", "A4", "A5"};
		String[][] fTowns1 = {new String[]{"A1", "X1"}, new String[]{"A2", "X2"}, new String[]{"A3", "X3"},
				new String[]{"A4", "X4"}};
		Map<String, Double> distTable1 = new HashMap<String, Double>();
		distTable1.put("X1", 100.0);
		distTable1.put("X2", 200.0);
		distTable1.put("X3", 250.0);
		distTable1.put("X4", 300.0);
		assertEquals(889, Tour.tour(friends1, fTowns1, distTable1));
	}
}