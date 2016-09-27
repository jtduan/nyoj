package algorithm.code.nyoj.nyoj63;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jtduan
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj63.txt"), "utf8");
        cin= new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        while(a!=0 && b!=0){
            System.out.println(soultion(a,b));
            a = cin.nextInt();
            b = cin.nextInt();
        }
    }

    private static int soultion(int a, int b) {
        int begin = (int)Math.pow(2,a-1);
        int end = (int)Math.pow(2,a);
        while(begin!=end){
            if(b%2==1){
                end = (begin+end)/2;
                b=(b+1)/2;
            }
            if(b%2==0){
                begin = (begin+end)/2;
                b=b/2;
            }
        }
        return begin;
    }
}
