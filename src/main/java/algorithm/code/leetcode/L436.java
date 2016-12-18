package algorithm.code.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jtduan
 * @date 2016/10/26
 */
public class L436 {
    class T {
        Interval interval;
        int index;

        public T(Interval interval, int index) {
            this.interval = interval;
            this.index = index;
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        T[] ts = new T[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            ts[i] = new T(intervals[i], i);
        }
        Arrays.sort(ts, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.interval.start - o2.interval.start;
            }
        });
        int[] res = new int[ts.length];
        for (int i = 0; i < ts.length; i++) {
            int index = Arrays.binarySearch(ts, new T(new Interval(ts[i].interval.end, 0), 0), new Comparator<T>() {
                @Override
                public int compare(T o1, T o2) {
                    return o1.interval.start - o2.interval.start;
                }
            });
            if (index < 0) index = -index - 1;
            if (index < ts.length) res[ts[i].index] = ts[index].index;
            else res[ts[i].index] = -1;
        }
        return res;
    }
}
