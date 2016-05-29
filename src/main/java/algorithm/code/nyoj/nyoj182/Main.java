package algorithm.code.nyoj.nyoj182;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jtduan
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner cin = null;
//		cin = new Scanner(new FileInputStream("src/main/resources/nyoj182.txt"), "utf8");
        cin= new Scanner(System.in);
		int N = cin.nextInt();
		for (int i = 0; i < N; i++) {
			everyTest(cin);
		}
	}

	private static void everyTest(Scanner cin) {
		int N = cin.nextInt();
		int points[][] = new int[N][2];
		for(int i = 0;i<N;i++){
			points[i][0]=cin.nextInt();
			points[i][1]=cin.nextInt();
		}
		System.out.println(solution(points));
	}

	private static int solution(int[][] points) {
		int n = points.length;
		int vector[][] = new int[n-1][2];
		int vector_len=0;
		int res=0;
		int num;
		for(int i=0;i<n;i++){
			vector_len=0;
			for(int j =i+1;j<n;j++){
				vector[vector_len][0]=points[j][0]-points[i][0];
				vector[vector_len][1]=points[j][1]-points[i][1];
				vector_len++;
			}
			for(int j=0;j<vector_len;j++){
				num=0;
				for(int k=0;k<vector_len;k++){
					if(k==j) continue;
					if(vector[j][0]*vector[k][1] == vector[j][1]*vector[k][0]){
						num++;
					}
				}
				if(num==1) res++;
			}
		}
		return res/2;
	}
}
