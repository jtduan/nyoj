package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author jtduan
 * @date 2016/11/10
 */
public class L22 {
    char[] stack;
    List<String> res;

    public List<String> generateParenthesis(int n) {
        int[] num = new int[]{n, 0};
        stack = new char[2*n];
        res = new ArrayList<>();
        dfs(num,0);
        return res;
    }

    private void dfs(int[] num,int cur) {
        if(num[0]==0 && num[1]==0){
            res.add(String.valueOf(stack));
        }
        if(num[0]>0){
            stack[cur]='(';
            num[0]--;
            num[1]++;
            dfs(num,cur+1);
            num[0]++;
            num[1]--;
        }
        if(num[1]>0){
            stack[cur]=')';
            num[1]--;
            dfs(num,cur+1);
            num[1]++;
        }
    }
}
