package algorithm.code.nyoj.nyoj127;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jtduan
 */
public class Main {
	public static int M =1000000;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner cin = null;
		cin = new Scanner(new FileInputStream("src/main/resources/nyoj127.txt"), "utf8");
//        cin= new Scanner(System.in);
		int N = cin.nextInt();
		for (int i = 0; i < N; i++) {
			everyTest(cin);
		}
	}

	private static void everyTest(Scanner cin) {
		System.out.println(fp(3,5));
	}

	public static int fp(int a,int b){
		long ret=1,pow=a;//ret：返回值；pow：基底
		while(b!=0){
			if((b&1)==1){
				ret=(ret*pow);
			}
			pow=(pow*pow);
			b/=2;//相当于b>>1
		}
		return (int)ret;
//		"sss".indexOf(1);
	}
}

