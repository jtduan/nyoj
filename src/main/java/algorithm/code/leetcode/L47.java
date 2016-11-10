package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author jtduan
 * @date 2016/11/8
 */
public class L47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        dfs(nums,visited,res,stack);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<List<Integer>> res, Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i>=1 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i]=true;
            stack.push(nums[i]);
            dfs(nums,visited,res,stack);
            stack.pop();
            visited[i]=false;
        }
    }
}
