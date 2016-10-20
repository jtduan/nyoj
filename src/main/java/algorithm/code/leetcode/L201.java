package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/19
 */
public class L201 {

    public int rangeBitwiseAnd(int m, int n) {
        int res=0;
        for(int i=0;i<32;i++){
            if(((m>>i) & 1) == 1 && 1==((n>>i) & 1) && (n-m+1)<(1<<i)){
                res+=(1<<i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new L201().rangeBitwiseAnd(5,7));
    }
}
