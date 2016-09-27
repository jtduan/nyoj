package algorithm.code.nyoj.nyoj32;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jtduan
 */
public class Main {
    public static int stack[];
//    public static int r;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj32.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        int r =cin.nextInt();
        stack = new int[r];
        dfs(N,r-1);
    }

    private static void dfs(int n, int r) {
//        if(n<r) return;
        for(int i=n;i>=1;i--) {
            stack[r]=i;
            if(r==0){
                for(int j=stack.length-1;j>=0;j--){
                    System.out.print(stack[j]);
                }
                System.out.println();
            }
            else{
                dfs(i - 1, r - 1);
            }
        }
    }
}
