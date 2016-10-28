package algorithm.code.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        if (k == 0 || nums == null || nums.length == 0 || k > nums.length) return 0;
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < queue.peek()) continue;
            else {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(89);
        queue.add(1);
        System.out.println(queue.poll());
    }
}
