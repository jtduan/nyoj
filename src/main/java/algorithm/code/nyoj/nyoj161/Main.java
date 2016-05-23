package algorithm.code.nyoj.nyoj161;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  威佐夫博弈问题
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
        cin = new Scanner(new FileInputStream("src/main/resources/nyoj161.txt"),"utf8");
//        cin=new Scanner(System.in);
        while(cin.hasNext()){
            int a= cin.nextInt();
            int b=cin.nextInt();
            solution(Math.min(a,b),Math.max(a,b));
        }
    }

    private static void solution(int a,int b) {
        if((int)((b-a)*(Math.sqrt(5)+ 1)/2) == a) System.out.println(0);
        else System.out.println(1);
    }
}
