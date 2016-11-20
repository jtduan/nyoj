package algorithm.code.acm;

import java.util.Arrays;

/**
 * Created by djt on 11/19/16.
 * 归并排序求逆序数
 */
public class J20092A {

	public static int res_num = 0;

	public static int[] MergeSort(int[] num) {
		if(num.length==1){
			return num;
		}
		int mid = (num.length - 1) / 2;
		int[] num1 = MergeSort(Arrays.copyOfRange(num, 0, mid+1));
		int[] num2 = MergeSort(Arrays.copyOfRange(num, mid+1, num.length));
		return merge(num1, num2);
	}

	private static int[] merge(int[] num1, int[] num2) {
		int[] res = new int[num1.length + num2.length];
		int cur1 = 0;
		int cur2 = 0;
		int cur = 0;
		while (cur1 < num1.length && cur2 < num2.length) {
			if (num1[cur1] <= num2[cur2]) {
				res[cur++] = num1[cur1++];
			} else {
				res[cur++] = num2[cur2++];
				res_num += num1.length - cur1;
			}
		}
		while (cur1 < num1.length) {
			res[cur++] = num1[cur1++];
		}
		while (cur2 < num2.length) {
			res[cur++] = num2[cur2++];
		}
		return res;
	}

	public static void main(String[] args) {
		res_num=0;
		int[] res = MergeSort(new int[]{3,2,1});
		System.out.println(res.length);
		System.out.println(res_num);
	}
}
