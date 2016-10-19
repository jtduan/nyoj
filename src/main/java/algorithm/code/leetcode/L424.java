package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/18
 * 解题思路：维护一个窗口，该窗口含有k个多余的数字,其他的全为最多的数字，随着窗口右移。得到结果
 */
public class L424 {
    public int characterReplacement(String s, int k) {
        int begin = 0;
        int[] nums = new int[26];
        int max = 0;
        char[] ch = s.toCharArray();
        if (ch.length == 0) return 0;
        int res = max;
        for (int end = 0; end < ch.length; end++) {
            nums[ch[end] - 'A']++;
            if (nums[ch[end] - 'A'] > max) {
                max = nums[ch[end] - 'A'];
            }

            while (end - begin + 1 - max > k) {
                nums[ch[begin] - 'A']--;
                /**从新计算max,不进行max计算也能得到正确结果**/
                /**因为窗口变小时不会是最终结果，最终窗口还会恢复到原先的大小(因此不需计算max)并继续变大到最终结果，之后窗口不再变化**/
//                max = 0;
//                for (int p = 0; p < nums.length; p++) {
//                    max = Math.max(max, nums[p]);
//                }

                begin++;
            }
            res = Math.max(res, end - begin + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new L424().characterReplacement("BAAA", 0));
    }
}
