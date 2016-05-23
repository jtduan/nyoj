package algorithm.code.nyoj.nyoj14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  使用SortedMap无法通过,原因未知
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj14.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int[] times = new int[10005];
        Arrays.fill(times,-1);
        int m=cin.nextInt();
        for(int i=0;i<m;i++){
            int begin =cin.nextInt();
            int end=cin.nextInt();
            if(times[end]<begin){
                times[end]=begin;
            }
        }
        int res=0;
        int time=-1;
        for(int i=0;i<times.length;i++){
            if(times[i]>time){
                res++;
                time=i;
            }
        }
        System.out.println(res);
    }

//    private static void everyTest(Scanner cin) {
//        int n = cin.nextInt();
//        SortedMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
//        for(int i=0;i<n;i++){
//            int value = cin.nextInt();
//            int key = cin.nextInt();
//            map.put(key,value);
//        }
//        solution(map);
//    }
//
//    private static void solution(SortedMap<Integer,Integer> map) {
//        int res =0;
//        int time =-1;
//        for(Integer i:map.keySet()){
//            if(map.get(i)>time){
//                res++;
//                time=i;
//            }
//        }
//        System.out.println(res);
//    }
}
