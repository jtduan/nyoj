package algorithm.code.leetcode;

import java.util.Set;

/**
 * Created by djt on 10/22/16.
 */
public class L139 {
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean res[] = new boolean[s.length()+1];
		res[0]=true;
		for(int i=1;i<res.length;i++){
			for(int j=i-1;j>=0;j--){
				if(res[j]==true && wordDict.contains(s.substring(j,i))){
					res[i]=true;
					break;
				}
			}
		}
		return res[res.length-1];
	}

}
