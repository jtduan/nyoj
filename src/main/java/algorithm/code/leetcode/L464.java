package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/21
 */
public class L464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean dp[][] = new boolean[1 << maxChoosableInteger][desiredTotal + 1];
        dp[1 << maxChoosableInteger - 1][0] = true;
        for(int i=1 << maxChoosableInteger - 2;i>=0;i--){

        }
        return dp[1 << maxChoosableInteger - 1][desiredTotal];
    }

    public static void main(String[] args) {
        System.out.println(new L464().canIWin(3, 6));
    }
}
