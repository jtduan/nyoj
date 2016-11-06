package algorithm.code.leetcode;

import java.util.Arrays;

/**
 * @author jtduan
 * @date 2016/10/28
 */
public class L321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return dfs(nums1, nums2, k);
    }

    public int[] dfs(int[] nums1, int[] nums2, int k) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (max < nums1[i] && nums2.length + nums1.length - i >= k) max = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            if (max < nums2[i] && nums2.length + nums1.length - i >= k) max = nums2[i];
        }
        if (k == 1) return new int[]{max};

        int[] maxs = new int[k - 1];
        for (int i = 0; i < nums1.length; i++) {
            if (max == nums1[i] && nums2.length + nums1.length - i >= k) {
                int[] temp = dfs(Arrays.copyOfRange(nums1, i + 1, nums1.length), nums2, k - 1);
                if (compare(maxs, temp) < 0) {
                    maxs = temp;
                }
                break;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (max == nums2[i] && nums2.length + nums1.length - i >= k) {
                int[] temp = dfs(nums1, Arrays.copyOfRange(nums2, i + 1, nums2.length), k - 1);
                if (compare(maxs, temp) < 0) {
                    maxs = temp;
                }
                break;
            }
        }

        int[] res = new int[k];
        res[0] = max;
        System.arraycopy(maxs, 0, res, 1, k - 1);
        return res;
    }

    private int compare(int[] maxs, int[] temp) {
        for (int i = 0; i < maxs.length; i++) {
            if (maxs[i] > temp[i]) return 1;
            if (maxs[i] < temp[i]) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] res = new L321().maxNumber(new int[]{6,7}, new int[]{6,0}, 4);
        for (int a : res) {
            System.out.println(a);
        }
    }
}
