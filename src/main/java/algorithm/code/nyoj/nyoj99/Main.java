package algorithm.code.nyoj.nyoj99;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  未通过
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
        cin = new Scanner(new FileInputStream("src/main/resources/nyoj99.txt"),"utf8");
//        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
//        SortedSet<String> set = new TreeSet<>();//
//        set.add("abs");
//        set.add("abs");
//        System.out.println(set.size());
    }

    private static void everyTest(Scanner cin) {
        int n =cin.nextInt();
        cin.nextLine();
        Map<Character,SortedSet<String>> maps = new HashMap<Character,SortedSet<String>>(); //需要修改
        int[] nums = new int[26];
        for(int i=0;i<n;i++){
            String str = cin.nextLine();
            char key = str.charAt(0);
            if(maps.get(key) == null) {
                SortedSet<String> set = new TreeSet<String>();
                maps.put(key,set);
            }
            maps.get(key).add(str);

            nums[key-'a']++;
            nums[str.charAt(str.length()-1)-'a']--;
        }
        char begin='a';
        char end='a';
        boolean hasbegin=false;
        boolean hasend = false;
        for(int i=0;i<26;i++){
            if(nums[i]==1 && hasbegin==false){
                begin = (char)('a'+i);
                hasbegin=true;
            }
            else if(nums[i]==-1 && hasend==false){
                end = (char)('a'+i);
                hasend=true;
            }
            else if(nums[i]==0){
                continue;
            }
            else {
                System.out.println("***");
                return;
            }
        }
        String end_str="";
        for(Character ch: maps.keySet()){
            for(String str:maps.get(ch)){
                if(str.charAt(str.length()-1) == end && compare(end_str,str)<0 ){
                    end_str = str;
                }
            }
        }
        solution(maps,begin,end_str);
    }

    private static int compare(String end_str, String str) {
        if(end_str==" ") return -1;
        return end_str.compareTo(str)<0?-1:1;
    }

    private static void solution(Map<Character,SortedSet<String>> maps, Character begin,String end) {
        String str_begin = maps.get(begin).first();
        while(str_begin!=end){
            maps.get(str_begin.charAt(0)).remove(str_begin);
            System.out.print(str_begin+".");
            str_begin = maps.get(str_begin.charAt(str_begin.length()-1)).first();
        }
        System.out.println(end);
//        System.out.print(maps.get(begin).first());
//        maps.get(begin).remove(maps.get(begin).first());
//        if(maps.get(begin).first()!= maps.get(end).last()){
//            System.out.print(".");
//        }
    }
}
