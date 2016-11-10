package algorithm.code.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * Created by djt on 11/5/16.
 */
public class L72 {
	public int minDistance(String word1, String word2) {
		if(word1.length()==0) return word2.length();
		if(word2.length()==0) return word1.length();
		int dp[][] = new int[word1.length()+1][word2.length()+1];
		for(int i=0;i<=word2.length();i++){
			dp[0][i]=i;
		}
		for(int i=0;i<=word1.length();i++){
			dp[i][0]=i;
		}
		for(int i=1;i<=word1.length();i++){
			for(int j=1;j<=word2.length();j++){
				if(word1.charAt(i)==word2.charAt(j)){
					dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])+1);
				}
				else
					dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
			}
		}
		return dp[word1.length()][word2.length()];
	}

}
