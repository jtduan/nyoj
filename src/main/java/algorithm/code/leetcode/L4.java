package algorithm.code.leetcode;

import java.util.Arrays;

/**
 * @author jtduan
 * @date 2016/11/9
 */
public class L4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int K = nums1.length + nums2.length;
        if (K % 2 == 1) return findKth(nums1, nums2, K / 2 +1);
        else {
            return (findKth(nums1, nums2, K / 2) + findKth(nums1, nums2, K / 2 + 1)) / 2.0;
        }
    }

    public double findKth(int[] nums1, int[] nums2, int K) {
        if (nums1.length == 0) return nums2[K - 1];
        if (nums2.length == 0) return nums1[K - 1];
        if (K == 1) return Math.min(nums1[0], nums2[0]);
        int mid = K / 2 -1;
        int temp1 = Integer.MAX_VALUE;
        int temp2 = Integer.MAX_VALUE;
        if (mid < nums1.length) temp1 = nums1[mid];
        if (mid < nums2.length) temp2 = nums2[mid];
        if (temp1 <= temp2) {
            return findKth(Arrays.copyOfRange(nums1, mid + 1, nums1.length), nums2, K - mid - 1);
        } else {
            return findKth(nums1, Arrays.copyOfRange(nums2, mid + 1, nums2.length), K - mid - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new L4().findMedianSortedArrays(new int[]{1,3,7,24},new int[]{2,3,4,5,6}));
    }
}
