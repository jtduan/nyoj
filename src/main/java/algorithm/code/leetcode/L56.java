package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by djt on 11/6/16.
 */
public class L56 {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.isEmpty()) return Collections.EMPTY_LIST;
		List<Interval> res = new ArrayList<>();
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		int min = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		for (Interval interval : intervals) {
			if (max == Integer.MIN_VALUE) {
				min = interval.start;
				max = interval.end;
				continue;
			}
			if (interval.start <= max) {
				max = Math.max(max, interval.end);
			} else {
				res.add(new Interval(min, max));
				min = interval.start;
				max = interval.end;
			}
		}
		res.add(new Interval(min, max));
		return res;
	}
}
