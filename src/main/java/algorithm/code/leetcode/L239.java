package algorithm.code.leetcode;

import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by djt on 11/12/16.
 */
public class L239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0) return new int[0];
		int[] res = new int[nums.length - k + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) deque.pollLast();
			deque.add(i);
			while (deque.getFirst() <= i - k) deque.pollFirst();
			if (i - k + 1 >= 0) res[i - k + 1] = nums[deque.getFirst()];
		}
		return res;
	}
}
