package algorithm.code.nyoj.nyoj236;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author jtduan
 * 原理：使用arr存储每一个递增序列已经到达的最大点，若新节点小于所有最大点，则增加arr长度，否则在arr中增加仅次于新最大点的一项
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj236.txt"), "utf8");
        cin= new Scanner(System.in);
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            int N = cin.nextInt();
            List<Stick> list = new ArrayList<Stick>();
            for (int j = 0; j < N; j++) {
                Stick s = new Stick();
                s.L = cin.nextInt();
                s.W = cin.nextInt();
                list.add(s);
            }
            Collections.sort(list, new Comparator<Stick>() {
                @Override
                public int compare(Stick o1, Stick o2) {
                    if(o1.L == o2.L){
                        return o1.W - o2.W;
                    }
                    else{
                        return o1.L-o2.L;
                    }
                }
            });
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int j=0;j<list.size();j++){
                push(arr,list.get(j));
            }
            System.out.println(arr.size());
        }
    }

    private static void push(ArrayList<Integer> arr, Stick stick) {
        int p = Collections.binarySearch(arr, stick.W, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        if(p>=0) return;
        else if(-p-1 == arr.size()){
            arr.add(stick.W);
        }
        else{
            arr.set(-p-1,stick.W);
        }
    }
}

class Stick {
    int W;
    int L;
}
