package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author jtduan
 * @date 2016/11/10
 */
public class L39 {
    private List<List<Integer>> res;
    private Stack<Integer> stack;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        stack = new Stack<>();
        dfs(candidates, target, candidates.length - 1);
        return res;
    }

    private void dfs(int[] candidates, int target, int max) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        if (target < 0) return;
        for (int i = 0; i <= max; i++) {
            if (i >= 1 && candidates[i] == candidates[i - 1]) continue;
            stack.push(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new L39().combinationSum(new int[]{1, 2}, 3).size());
    }
}
