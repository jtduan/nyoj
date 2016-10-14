package algorithm.code.nyoj.nyoj214;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 使用一个数组存储长度为i时最小的最大值
 */
public class Main {
    private static int[] num;
    private static ArrayList<Integer> max;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj214.txt"), "utf8");
        cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int N = cin.nextInt();
            num = new int[N];
            for (int i = 0; i < N; i++) {
                num[i] = cin.nextInt();
            }
            System.out.println(solutionn());
        }
    }

    private static int solutionn() {
        max = new ArrayList<Integer>();
        for(int i=0;i<num.length;i++){
            int index = Collections.binarySearch(max,num[i]);
            if(index<0){
                if(-index-1 == max.size()){
                    max.add(num[i]);
                }
                else{
                    max.set(-index-1,num[i]);
                }
            }
        }
        return max.size();
    }
}