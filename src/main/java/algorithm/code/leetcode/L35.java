package algorithm.code.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by djt on 10/22/16.
 */
public class L35 {

	public int searchInsert(int[] nums, int target) {
		int index = Arrays.binarySearch(nums,target);
		if(index<0) return -index-1;
		return index;
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<>();
		for(String str:strs){
			char[] temp = str.toCharArray();
			Arrays.sort(temp);
			if(map.containsKey(temp.toString())) map.get(temp.toString()).add(str);
            else {
				map.put(temp.toString(),new ArrayList<String>());
				map.get(temp.toString()).add(str);
			}
		}
		return new ArrayList<List<String>>(map.values());
	}

}
