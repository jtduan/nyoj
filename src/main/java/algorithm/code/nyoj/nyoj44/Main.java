package algorithm.code.nyoj.nyoj44;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  nyoj模板代码
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj44.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int n = cin.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=cin.nextInt();
        }
        solution(nums);
    }

    private static void solution(int[] nums) {
        if(nums.length==0) return;
        int max = nums[0];
        int cur=nums[0]>0?nums[0]:0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]+cur>max) max=nums[i]+cur;
            cur=nums[i]+cur;
            if(cur<0)cur=0;
        }
        System.out.println(max);
    }
}
