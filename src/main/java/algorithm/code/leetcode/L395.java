package algorithm.code.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L395 {
    private int longest;

    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        longest = 0;
        dfs(chars, k);
        return longest;
    }

    private void dfs(char[] chars, int k) {
        if (chars.length < k) return;

        int[] nums = new int[26];
        for (int i = 0; i < chars.length; i++) {
            nums[chars[i] - 'a']++;
        }
        Set<Character> sets = new TreeSet<>();
        for (int i = 0; i < 26; i++) {
            if (nums[i] < k && nums[i] > 0) sets.add((char) ('a' + i));
        }
        if (sets.isEmpty()) {
            longest = Math.max(longest, chars.length);
            return;
        }

        int start = 0;
        int end = 0;
        while (end < chars.length) {
            if (sets.contains(chars[end])) {
                dfs(Arrays.copyOfRange(chars, start, end), k);
                start = end + 1;
            }
            end++;
        }
        if (start < end) dfs(Arrays.copyOfRange(chars, start, end), k);
    }

    public static void main(String[] args) {
        System.out.println(new L395().longestSubstring("aaabb", 3));
    }
}
