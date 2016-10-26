package algorithm.code.test;

import java.util.*;

/**
 * Created by hero on 2016/5/23.
 */
public class Test {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> map =new TreeMap<>();
        map.put(1,11);
        map.put(2,15);
        map.put(3,19);
        System.out.println("ss");
        ArrayList list = new ArrayList();
        list.add(5);
        list.add(8);
        list.add(1,6);
        System.out.println("ss");
        List<String> s = Collections.checkedList(list,String.class);
        s.add("ss");
        s.remove(0);
        System.out.println(s.size());
    }
}
