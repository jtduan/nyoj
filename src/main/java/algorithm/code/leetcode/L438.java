package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jtduan
 * @date 2016/10/26
 */
public class L438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return Collections.emptyList();
        int nums[] = new int[26];
        int src[] = new int[26];
        for (int i = 0; i < p.length(); i++) {
            nums[s.charAt(i) - 'a']++;
            src[p.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if (matches(nums, src)) res.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            nums[s.charAt(i - p.length()) - 'a']--;
            nums[s.charAt(i) - 'a']++;
            if (matches(nums, src)) res.add(i - p.length() + 1);
        }
        return res;
    }

    private boolean matches(int[] nums, int[] src) {
        for (int i = 0; i < 26; i++) {
            if (nums[i] != src[i]) return false;
        }
        return true;
    }
}
