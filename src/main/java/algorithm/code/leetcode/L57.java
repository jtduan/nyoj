package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jtduan
 * @date 2016/11/11
 */
public class L57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

//        int start = Collections.binarySearch(intervals, newInterval, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
//        int end = Collections.binarySearch(intervals, newInterval, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.end - o2.end;
//            }
//        });
//        if (start < 0) start = -start - 1;
//        if (end < 0) end = -end - 1;

        List<Interval> res = new ArrayList<>();
        boolean flag = false;
        for (Interval in : intervals) {
            if (in.end < newInterval.start) res.add(in);
            else if (in.end > newInterval.start && in.end < newInterval.end) {
                newInterval.start = Math.min(in.start, newInterval.start);
            } else if (in.start < newInterval.end && in.end > newInterval.end) {
                newInterval.end = in.end;
                newInterval.start = Math.min(in.start,newInterval.start);
            } else if (in.start > newInterval.end) {
                if (flag == false) {
                    res.add(newInterval);
                    flag = true;
                }
                res.add(in);
            }
        }
        if (flag == false) {
            res.add(newInterval);
        }
        return res;
    }
}
