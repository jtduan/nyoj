package algorithm.code.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author jtduan
 * @date 2016/11/8
 */
public class L40 {
    private List<List<Integer>> res;
    private Stack<Integer> stack;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        stack = new Stack<>();
        dfs(candidates, target);
        return res;
    }

    private void dfs(int[] candidates, int target) {
        if (target == 0){
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (i >= 1 && candidates[i] == candidates[i - 1]) continue;
            stack.push(candidates[i]);
            dfs(Arrays.copyOfRange(candidates, i + 1, candidates.length), target - candidates[i]);
            stack.pop();
        }
    }
}
