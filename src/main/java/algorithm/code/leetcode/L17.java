package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author jtduan
 * @date 2016/11/10
 */
public class L17 {
    char[] stack;
    List<String> res;
    String strs[] = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        stack = new char[digits.length()];
        res = new ArrayList<>();
        dfs(digits.toCharArray(),0);
        return res;
    }

    private void dfs(char[] chars,int cur) {
        if (chars.length == cur) {
            if(cur!=0)res.add(String.valueOf(stack));
            return;
        }
        for (int i = 0; i < strs[chars[cur] - '2'].length(); i++) {
            stack[cur] = strs[chars[cur] - '2'].charAt(i);
            dfs(chars,cur+1);
        }
    }
}
