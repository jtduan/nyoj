package algorithm.code.nyoj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  @author jtduan
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj2.txt"),"utf8");
////        cin= new Scanner(System.in);
//        int N = cin.nextInt();
//        for(int i=0;i<N;i++){
//            everyTest(cin);
//        }
        //[2,5,7,9,11] ,[11,9,7,5,2]
        ArrayList list = new ArrayList();
        list.add(11);
        list.add(9);
        list.add(7);
        list.add(5);
        list.add(2);
        System.out.println(Collections.binarySearch(list, 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        }));
    }

    private static void everyTest(Scanner cin) {
        solution();
    }

    private static void solution() {
        int[] src = new int[]{1,2,3};
        int[] dst = Arrays.copyOfRange(src,0,3);
        System.out.println(dst.length);
    }
}