package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/1
 */
public class L383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        int res[] = new int[26];
        int target[] = new int[26];
        for (char ch : ransomNote.toCharArray()) {
            target[ch - 'a']++;
        }
        for (char ch : magazine.toCharArray()) {
            res[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (res[i] < target[i]) return false;
        }
        return true;
    }
}
