package algorithm.code.leetcode;

import java.util.Arrays;

/**
 * @author jtduan
 * @date 2016/11/11
 */
public class L44 {
    public boolean isMatch(String s, String p) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                int left = 0;
                while (left < dp.length) {
                    if (dp[left] == i) break;
                    left++;
                }
                for (int j = left; j < dp.length; j++) dp[j] = i + 1;
            } else if (p.charAt(i) == '?') {
                for (int j = s.length() - 1; j >= 0; j--) {
                    if (dp[j] == i) dp[j + 1] = i + 1;
                }
            } else {
                for (int j = s.length()-1; j >=0; j--) {
                    if (dp[j] == i && s.charAt(j) == p.charAt(i)) dp[j + 1] = i + 1;
                }
            }
        }
        if (dp[dp.length - 1] == p.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new L44().isMatch("aa", "*a"));
    }
}
