package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/4
 */
public class L345 {
    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) return s;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if ("aeiouAEIOU".indexOf(chars[left])<0) {
                left++;
                continue;
            }
            if ("aeiouAEIOU".indexOf(chars[right])<0) {
                right--;
                continue;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
