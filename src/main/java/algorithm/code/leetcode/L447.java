package algorithm.code.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by djt on 11/13/16.
 */
public class L447 {
	public int numberOfBoomerangs(int[][] points) {
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				if (i == j) continue;
				int dis = getDistance(points, i, j);
				if (map.get(dis) == null) map.put(dis, 0);
				res += 2 * map.get(dis);
				map.put(dis, map.get(dis) + 1);
			}
		}
		return res;
	}

	private int getDistance(int[][] points, int i, int j) {
		return (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
				+ (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
	}
}
