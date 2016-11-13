package algorithm.code.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by djt on 11/13/16.
 */
public class L452 {
	public int findMinArrowShots(int[][] points) {
		Line[] lines = new Line[points.length];
		for (int i = 0; i < points.length; i++) {
			lines[i] = new Line(points[i][0], points[i][1]);
		}
		Arrays.sort(lines, new Comparator<Line>() {
			@Override
			public int compare(Line o1, Line o2) {
				return o1.start - o2.start;
			}
		});

		int res = 0;
		Line cur = null;
		for (int i = 0; i < lines.length; i++) {
			if (cur == null) {
				cur = lines[i];
			} else if (lines[i].start < cur.end) {
				cur = new Line(lines[i].start, Math.min(cur.end, lines[i].end));
			} else {
				res++;
				cur = null;
			}
		}
		return res;
	}
}

class Line {
	int start;
	int end;

	public Line(int start, int end) {
		this.start = start;
		this.end = end;
	}
}