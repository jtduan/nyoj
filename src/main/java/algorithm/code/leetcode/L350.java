package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by djt on 10/26/16.
 */
public class L350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		ArrayList<Integer> list = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums1.length;i++){
			if(map.get(nums1[i])==null) map.put(nums1[i],1);
			else map.put(nums1[i],map.get(nums1[i])+1);
		}

		for(int i=0;i<nums2.length;i++){
			if(map.get(nums2[i])!=null && map.get(nums2[i])>=1){
				map.put(nums2[i],map.get(nums2[i])-1);
				list.add(nums2[i]);
			}
		}
		int[] res = new int[list.size()];
		for(int i=0;i<list.size();i++){
			res[i]=list.get(i);
		}
		return res;
	}
}
