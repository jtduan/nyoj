package algorithm.code.leetcode;

import java.util.Stack;

/**
 * @author jtduan
 * @date 2016/11/3
 */
public class L71 {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack();
        for (String str : strs) {
            if (str.isEmpty() || str.trim().equals(".")) continue;
            if (str.trim().equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(str);
            }
        }
        return "/" + String.join("/", stack);
    }
}
