package algorithm.code.nyoj.nyoj223;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jtduan
 */
public class Main {
    public static int[] nums = new int[]{2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj223.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        String str =cin.nextLine();
        for(char ch:str.toCharArray()){
            System.out.print(nums[ch-'a']);
        }
        System.out.println();
    }
}
