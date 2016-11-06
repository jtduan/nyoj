package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L392 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() == 0) return false;
        char[] ch_s = t.toCharArray();
        char[] ch_t = s.toCharArray();
        int cur = 0;
        for (int i = 0; i < ch_s.length; i++) {
            if (ch_s[i] == ch_t[cur]) {
                cur++;
                if (cur == ch_t.length) return true;
            }
        }
        return false;
    }
}
