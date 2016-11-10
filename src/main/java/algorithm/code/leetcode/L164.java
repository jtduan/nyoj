package algorithm.code.leetcode;

import java.util.Arrays;

/**
 * Created by djt on 11/6/16.
 */
public class L164 {
	public int maximumGap(int[] nums) {
		if (nums.length < 2) return 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			if (num > max) max = num;
			if (num < min) min = num;
		}
		if(max==min) return 0;
		int[] bucket_min = new int[nums.length+1];
		int[] bucket_max = new int[nums.length+1];
		Arrays.fill(bucket_max, -1);
		Arrays.fill(bucket_min, -1);
		double range = (max-min)/nums.length;
		for (int num : nums) {
			if(bucket_max[(int)((num-min)/range)]==-1){
				bucket_max[(int)((num-min)/range)] = num;
				bucket_min[(int)((num-min)/range)] = num;
			}
			if (bucket_max[(int)((num-min)/range)] < num) bucket_max[(int)((num-min)/range)] = num;
			if (bucket_min[(int)((num-min)/range)] > num) bucket_min[(int)((num-min)/range)] = num;
		}
		int res = 0;
		int i=0;
		while(bucket_max[i]==-1)i++;
		int pre = bucket_max[i];
		for(int j=i+1;j<bucket_max.length;j++){
			if(bucket_max[j]==-1) continue;
			res = Math.max(res,bucket_min[j]-pre);
			pre=bucket_max[j];
		}
		return res;
	}
}