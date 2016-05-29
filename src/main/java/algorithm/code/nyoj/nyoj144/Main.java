package algorithm.code.nyoj.nyoj144;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jtduan
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner cin = null;
//		cin = new Scanner(new FileInputStream("src/main/resources/nyoj144.txt"), "utf8");
        cin= new Scanner(System.in);
		while(cin.hasNext()){
			int a = cin.nextInt();
			int b = cin.nextInt();
			int c = cin.nextInt();
			solution(a,b,c);
		}
	}
	private static void solution(int a,int b,int c) {
		if(a==0&&b==0&&c==0){
			System.out.println(0);
			return;
		}
		byte[] num1=new byte[100];
		byte[] num2=new byte[100];
		byte[] num3=new byte[100];
		byte[] res=new byte[100];
		int len1=convert(a,num1);
		int len2=convert(b,num2);
		int len3=convert(c,num3);
		int n = Math.max(Math.max(len1,len2),len3);
		for(int p=4;p<=100;p++){
			int flag=0;
			for(int j=0;j<n;j++){
				res[j]=(byte)((num1[j]+num2[j]+num3[j]+flag)%10);
				flag = (num1[j]+num2[j]+num3[j]+flag)/10;
			}
			if(flag!=0){
				res[n]=(byte)flag;
				n++;
			}
			byte[]temp=num1;
			num1=num2;
			num2=num3;
			num3=res;
			res=temp;
		}
		for(int i=n-1;i>=0;i--){
			System.out.print(num3[i]);
		}
		System.out.println();
	}

	private static int convert(int a, byte[] num2) {
		int i=0;
		while(a!=0){
			num2[i++]=(byte)(a%10);
			a=a/10;
		}
		return i;
	}
}
