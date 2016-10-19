package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/18
 */
public class L264 {
    public int nthUglyNumber(int n) {
        int cur_2 = 0;
        int cur_3 = 0;
        int cur_5 = 0;
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(nums[cur_2] * 2, Math.min(nums[cur_3] * 3, nums[cur_5] * 5));

            if (min == nums[cur_2] * 2) cur_2++;
            if (min == nums[cur_3] * 3) cur_3++;
            if (min == nums[cur_5] * 5) cur_5++;

            nums[i] = min;
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new L264().nthUglyNumber(10));
    }
}
