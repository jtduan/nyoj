package algorithm.code.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jtduan
 * @date 2016/11/1
 */
public class L435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int rightest = intervals[0].end;
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < rightest) {
                rightest = Math.min(rightest, intervals[i].end);
                res++;
            } else {
                rightest = intervals[i].end;
            }
        }
        return res;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}