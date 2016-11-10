package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/31
 */
public class L5 {
    public String longestPalindrome(String s) {
        int max=1;
        int index=0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        for(int i=0;i<chars.length;i++){
            dp[i][i]=true;
        }
        for(int i=0;i<chars.length-1;i++){
            dp[i][i+1]=chars[i]==chars[i+1];
            if(dp[i][i+1]) {
                max = 2;
                index = i;
            }
        }
        for(int i=2;i<chars.length;i++){
            for(int j=0;j<chars.length;j++){
                dp[j][j+i]=dp[j+1][j+i-1] && chars[j]==chars[j+i];
                if(dp[j][j+i] && max<i+1){
                    max=i+1;
                    index=j;
                }
            }
        }
        return String.valueOf(chars,index,max);
    }
}
