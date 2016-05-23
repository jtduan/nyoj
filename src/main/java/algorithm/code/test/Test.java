package algorithm.code.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by hero on 2016/5/23.
 */
public class Test {
    public static void main(String[] args) {
        Integer[] num = new Integer[]{1,4,7,2,9,3,6};
        Arrays.sort(num, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) return 1;
                if(o1<o2) return -1;
                else return 0;
            }
        });
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
}
