package algorithm.code.nyoj.nyoj86;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *  不含相同元素的查找
 *  使用hashmSet
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj86.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        int M = cin.nextInt();
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<N;i++){
            set.add(cin.nextInt());
        }
        for(int i=0;i<M;i++){
            if(set.contains(cin.nextInt())){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
