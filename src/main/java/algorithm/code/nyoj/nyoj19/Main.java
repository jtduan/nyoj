package algorithm.code.nyoj.nyoj19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  @author jtduan
 */
public class Main {
    private static int N;
    private static int M;
    private static int[] nums;
    private static int cur;
    private static int[] set;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj19.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        N = cin.nextInt();
        M = cin.nextInt();
        nums=new int[M];
        cur=0;
        set = new int[10];
        dfs(M);
    }

    private static void dfs(int num) {
        if(num==0){
            for(int i=0;i<nums.length;i++){
                System.out.print(nums[i]);
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=N;i++){
            if(set[i]==1){
                continue;
            }
            nums[cur]=i;
            set[nums[cur]]=1;
            cur++;
            dfs(num-1);
            cur--;
            set[nums[cur]]=0;
        }
    }
}