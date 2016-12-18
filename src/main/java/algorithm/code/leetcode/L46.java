package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jtduan
 * @date 2016/11/11
 */
public class L46 {
    Stack<Integer> stack;
    boolean[] visited;
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        stack = new Stack<>();
        visited = new boolean[nums.length];
        res = new ArrayList<>();
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(visited[i])continue;
            stack.push(nums[i]);
            visited[i]=true;
            dfs(nums);
            visited[i]=false;
            stack.pop();
        }
        if(stack.size()==nums.length){
            res.add(new ArrayList<Integer>(stack));
        }
    }
}
