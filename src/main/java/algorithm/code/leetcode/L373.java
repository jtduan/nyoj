package algorithm.code.leetcode;

import java.util.*;

/**
 * @author jtduan
 * @date 2016/10/25
 */
public class L373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return Collections.emptyList();
        }
        PriorityQueue<Pairs> queue = new PriorityQueue<>();
        Set<Pairs> set = new HashSet<>();
        Pairs first = new Pairs(0, 0, nums1[0] + nums2[0]);
        queue.add(first);
        set.add(first);
        while (k >= 1) {
            k--;
            if (!queue.isEmpty()) {
                Pairs p = queue.poll();
                res.add(new int[]{nums1[p.i], nums2[p.j]});
                Pairs temp = new Pairs(p.i + 1, p.j,nums1[p.i + 1] + nums2[p.j]);
                if (p.i < nums1.length - 1 && !set.contains(temp)) {
                    queue.add(temp);
                    set.add(temp);
                }
                temp = new Pairs(p.i, p.j + 1, nums1[p.i] + nums2[p.j + 1]);
                if (p.j < nums2.length - 1 && !set.contains(new Pairs(p.i, p.j + 1, 0))) {
                    queue.add(temp);
                    set.add(temp);
                }
            }
        }
        return res;
    }

    class Pairs implements Comparable<Pairs> {
        int i;
        int j;
        int val;

        public Pairs(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int compareTo(Pairs o) {
            return this.val - o.val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pairs pairs = (Pairs) o;

            if (i != pairs.i) return false;
            return j == pairs.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
