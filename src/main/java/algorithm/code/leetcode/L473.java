package algorithm.code.leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by djt on 12/18/16.
 */

public class L473 {
	private int[] visited;
	Set<Integer> res;
	public boolean makesquare(int[] nums) {
		if(nums.length==0) return false;

		int sum=0;
		for(int num:nums){
			sum+=num;
		}
		if(sum%4!=0) return false;
		sum=sum/4;

		visited = new int[nums.length];
		res = new TreeSet<>();
		dfs(nums,sum);

		int len =(int)Math.pow(2,nums.length);
		boolean[] dp = new boolean[len];
		dp[0]=true;
		for(int num:res){
			for(int i=dp.length-1;i>=0;i--){
				if(dp[i] && valid(i,num)){
					dp[i|num]=true;
				}
			}
		}
		return dp[len-1];
	}

	private boolean valid(int num1, int num2) {
		return (num1&num2)==0;
	}

	public boolean dfs(int[] nums,int sum){
		if(sum==0){
			int num=0;
			for(int i=0;i<nums.length;i++){
				if(visited[i]==1) num+=(1<<i);
			}
			res.add(num);
		}

		for(int i=nums.length-1;i>=0;i--){
			if(visited[i]==0 && nums[i]<=sum){
				visited[i]=1;
				dfs(nums,sum-nums[i]);
				visited[i]=0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new L473().makesquare(new int[]{1,1,2,2,2}));
	}
}