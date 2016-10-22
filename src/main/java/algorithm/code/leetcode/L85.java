package algorithm.code.leetcode;

/**
 * Created by djt on 10/22/16.
 */
public class L85 {

	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if(m == 0) return 0;

		int n = matrix[0].length;
		if(n == 0) return 0;

		int maxRec = 0;

		int [] left = new int[n];
		int [] right = new int[n];
		int [] height = new int[n];

		for(int i = 0; i<n; ++i) right[i] = n;
		for(int i = 0; i<m; ++i){
			//calculate heights
			for(int j = 0;j<n; ++j){
				height[j] = matrix[i][j] == '0'? 0: height[j]+1;
			}

			int cur_left = 0;
			for(int j = 0; j<n; ++j){
				if(matrix[i][j] != '0') left[j] = Math.max(left[j], cur_left);
				else{
					left[j] = 0;
					cur_left = j + 1;
				}
			}
			int cur_right = n;
			for(int j =n-1; j>=0; --j){
				if(matrix[i][j] != '0') right[j] = Math.min(right[j], cur_right);
				else{
					right[j] = n;
					cur_right = j;
				}
			}

			for(int j = 0; j<n; ++j){
				maxRec = Math.max(maxRec, height[j] *(right[j]-left[j]));
			}
		}
		return maxRec;
	}
}
