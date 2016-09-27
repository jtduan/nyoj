package algorithm.code.nyoj.nyoj106;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jtduan
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj106.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int s = cin.nextInt();
        int m = cin.nextInt();
        int values[] = new int[200];
        int cur=0;
        for(int i=0;i<s;i++){
            int value = cin.nextInt();
            int weight = cin.nextInt();
            for(int j=0;j<weight;j++){
                values[cur++]=value;
            }
        }
        int sum=0;
        Arrays.sort(values);
        for(int i=values.length-1;i>values.length-1-m;i--){
            sum+=values[i];
        }
        System.out.println(sum);
    }
}