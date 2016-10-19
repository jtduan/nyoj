package algorithm.code.leetcode;

import java.util.PriorityQueue;

/**
 * @author jtduan
 * @date 2016/10/18
 */
public class L313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        for(int i=0;i<index.length;i++){
            index[i]=0;
        }
        int res[] = new int[n];
        res[0]=1;
        for(int i=1;i<n;i++){
            int min =Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                if(min>res[index[j]]*primes[j]) min = res[index[j]]*primes[j];
            }

            for(int j=0;j<primes.length;j++){
                if(min == res[index[j]]*primes[j]) index[j]++;
            }
            res[i]= min;
        }
        return res[n-1];
    }

    public static void main(String[] args) {
        for(int i=1;i<12;i++) {
            System.out.println(new L313().nthSuperUglyNumber(i, new int[]{2, 7, 13, 19}));
        }
    }
}
