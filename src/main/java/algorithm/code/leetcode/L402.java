package algorithm.code.leetcode;

import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author jtduan
 * @date 2016/10/28
 */
public class L402 {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) return "0";
        char[] chars = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            while (!stack.isEmpty() && stack.peek() > chars[i] && k > 0) {
                k--;
                stack.pop();
            }
            if (!stack.isEmpty() || chars[i] != '0') stack.push(chars[i]);
        }
        while(k>0 && !stack.isEmpty()){
            k--;
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.length()!=0?sb.reverse().toString():"0";
    }

    public static void main(String[] args) {
        System.out.println(new L402().removeKdigits("112",1));
    }
}
