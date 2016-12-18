package algorithm.code.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by djt on 11/13/16.
 */
public class L454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer,Integer> map1 = new HashMap<>();
		Map<Integer,Integer> map2 = new HashMap<>();
		for(int i=0;i<A.length;i++){
			for(int j=0;j<B.length;j++){
				map1.put(A[i]+B[j],map1.getOrDefault(A[i]+B[j],0)+1);
			}
		}
		for(int i=0;i<C.length;i++){
			for(int j=0;j<D.length;j++){
				map2.put(C[i]+D[j],map2.getOrDefault(C[i]+D[j],0)+1);
			}
		}
		int res=0;
		for(Integer num:map1.keySet()){
			res+=map1.get(num)*map2.getOrDefault(-num,0);
		}
		return res;
	}
}
