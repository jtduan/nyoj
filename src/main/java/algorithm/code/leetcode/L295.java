package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by djt on 11/12/16.
 */
public class L295 {
	public static List<Integer> list = new ArrayList<Integer>();
	// Adds a number into the data structure.
	public static void addNum(int num) {
		int index = Collections.binarySearch(list,num);
		if(index<0) index = -index-1;
		list.add(index,num);
	}

	// Returns the median of current data stream
	public static double findMedian() {
		if(list.size()%2==0){
			return (list.get(list.size()/2-1)+list.get(list.size()/2))/2.0;
		}
		else
			return list.get(list.size()/2)/2.0;
	}

	public static void main(String[] args) {
		L295.addNum(1);
		L295.addNum(2);
//		System.out.println(findMedian());
		L295.addNum(3);
		System.out.println(findMedian());
	}
}
