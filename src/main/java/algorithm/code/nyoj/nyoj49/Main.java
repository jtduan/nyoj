package algorithm.code.nyoj.nyoj49;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jtduan
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner cin = null;
//		cin = new Scanner(new FileInputStream("src/main/resources/nyoj49.txt"), "utf8");
        cin= new Scanner(System.in);
		int N = cin.nextInt();
		for (int i = 0; i < N; i++) {
			everyTest(cin);
		}
	}

	private static void everyTest(Scanner cin) {
		int N = cin.nextInt();
		int m =cin.nextInt();
		int weight[] = new int[m];
		int value[] = new int[m];
		for(int i=0;i<m;i++){
			weight[i]=cin.nextInt();
			value[i]=weight[i]*cin.nextInt();
		}
		int[] dp = new int[N+1];
		for(int i =0;i<m;i++){
			for(int j=N;j>=weight[i];j--){
				dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
			}
		}
		System.out.println(dp[N]);
	}
}
