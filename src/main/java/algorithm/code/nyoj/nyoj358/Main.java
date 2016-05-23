package algorithm.code.nyoj.nyoj358;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  斐波那契博弈
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
        cin = new Scanner(new FileInputStream("src/main/resources/nyoj358.txt"),"utf8");
//        cin= new Scanner(System.in);
        while(cin.hasNext()){
            solution(cin.nextLong());
        }
    }

    private static void solution(long num) {
        long a=1;
        long b=1;
        long c=a+b;
        while(c<num){
            a=b;
            b=c;
            c=a+b;
        }
        if(c==num) System.out.println("No");
        else System.out.println("Yes");
    }
}
