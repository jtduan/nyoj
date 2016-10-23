package algorithm.code.codewars;

import java.util.PriorityQueue;

/**
 * Created by djt on 10/23/16.
 */
class DoubleLinear {

	public static int dblLinear (int n) {
		int[] num = new int[n+1];
		num[0]=1;
		int index_2=0;
		int index_3=0;
		for(int i=1;i<num.length;i++){
			if(num[index_2]*2<num[index_3]*3){
				num[i]=num[index_2]*2+1;
				index_2++;
			}
			else if(num[index_2]*2==num[index_3]*3){
				num[i]=num[index_2]*2+1;
				index_2++;
				index_3++;
			}
			else{
				num[i]=num[index_3]*3+1;
				index_3++;
			}
		}

		return num[n];
	}
}