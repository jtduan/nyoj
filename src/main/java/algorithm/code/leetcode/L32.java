package algorithm.code.leetcode;

import java.util.Arrays;

/**
 * @author jtduan
 * @date 2016/11/10
 */
public class L32 {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int size = s.length();
        int[] len = new int[size + 1];
        Arrays.fill(len, 0);
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (i > len[i] && chars[i] == ')' && chars[i - len[i] - 1] == '(') {
                len[i + 1] = len[i] + 2 + len[i - len[i] - 1];
                max = Math.max(len[i + 1], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new L32().longestValidParentheses("((()))()"));
    }
}
