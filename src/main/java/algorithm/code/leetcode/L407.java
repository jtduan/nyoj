package algorithm.code.leetcode;

import java.util.*;

/**
 * Created by djt on 11/5/16.
 */
public class L407 {
	PriorityQueue<Point> queue;
	int[][] visited;
	int res = 0;

	public int trapRainWater(int[][] heightMap) {
		if (heightMap.length == 0) return 0;
		init(heightMap);

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			queue.addAll(getNeibor(cur, heightMap));
		}
		return res;
	}

	private List<Point> getNeibor(Point cur, int[][] heightMap) {
		List<Point> list = new ArrayList<>();
		if (cur.x > 0 && visited[cur.x - 1][cur.y] < 0) {
			res += Math.max(0, cur.height - heightMap[cur.x - 1][cur.y]);
			list.add(new Point(cur.x - 1, cur.y, Math.max(cur.height, heightMap[cur.x - 1][cur.y])));
			visited[cur.x - 1][cur.y] = 0;
		}
		if (cur.y > 0 && visited[cur.x][cur.y - 1] < 0) {
			res += Math.max(0, cur.height - heightMap[cur.x][cur.y - 1]);
			list.add(new Point(cur.x, cur.y - 1, Math.max(cur.height, heightMap[cur.x][cur.y - 1])));
			visited[cur.x][cur.y - 1] = 0;
		}
		if (cur.x < heightMap.length - 1 && visited[cur.x + 1][cur.y] < 0) {
			res += Math.max(0, cur.height - heightMap[cur.x + 1][cur.y]);
			list.add(new Point(cur.x + 1, cur.y, Math.max(cur.height, heightMap[cur.x + 1][cur.y])));
			visited[cur.x + 1][cur.y] = 0;
		}
		if (cur.y < heightMap[0].length - 1 && visited[cur.x][cur.y + 1] < 0) {
			res += Math.max(0, cur.height - heightMap[cur.x][cur.y + 1]);
			list.add(new Point(cur.x, cur.y + 1, Math.max(cur.height, heightMap[cur.x][cur.y + 1])));
			visited[cur.x][cur.y + 1] = 0;
		}
		return list;
	}

	private void init(int[][] heightMap) {
		int x = heightMap.length;
		int y = heightMap[0].length;
		queue = new PriorityQueue<Point>();
		visited = new int[x][y];
		for (int i = 0; i < x; i++) {
			Arrays.fill(visited[i], -1);
		}
		for (int i = 0; i < x; i++) {
			if (visited[i][0] < 0) {
				queue.add(new Point(i, 0, heightMap[i][0]));
				visited[i][0] = 0;
			}
			if (visited[i][y - 1] < 0) {
				queue.add(new Point(i, y - 1, heightMap[i][y - 1]));
				visited[i][y - 1] = 0;
			}
		}
		for (int j = 0; j < y; j++) {
			if (visited[0][j] < 0) {
				queue.add(new Point(0, j, heightMap[0][j]));
				visited[0][j] = 0;
			}
			if (visited[x - 1][j] < 0) {
				queue.add(new Point(x - 1, j, heightMap[x - 1][j]));
				visited[x - 1][j] = 0;
			}
		}
	}

//	public static void main(String[] args) {
//		int[][] map = new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
//		System.out.println(new L407().trapRainWater(map));
//	}
}

class Point implements Comparable<Point> {
	int x;
	int y;
	int height;

	public Point(int x, int y, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
	}

	@Override
	public int compareTo(Point o) {
		return height - o.height;
	}
}