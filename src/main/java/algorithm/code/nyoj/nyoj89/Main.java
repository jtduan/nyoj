package algorithm.code.nyoj.nyoj89;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  nyoj模板代码
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj89.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int m = cin.nextInt();
        List<Set<Integer>> lines= new ArrayList<Set<Integer>>();
        Set<Integer> line1 = new HashSet<Integer>();
        Set<Integer> line2 = new HashSet<Integer>();
        Set<Integer> line3 = new HashSet<Integer>();
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        for(int i=1;i<=m;i++){
            int p=cin.nextInt();
            if(p==1){
                line1.add(i);
            }
            else if(p==2){
                line2.add(i);
            }
            else if(p==3){
                line3.add(i);
            }
        }
        System.out.println(solution(lines,m,2));
    }

    private static int solution(List<Set<Integer>> lines,int max,int target) {
        int line_max=4;
        for(int i=0;i<lines.size();i++) {
            if (lines.get(i).contains(max)) line_max = i;
        }

        if(max==1){
            if(line_max == target) return 0;
            return 1;
        }
        if(line_max==target){
//            lines.get(line_max).remove(max);
            return solution(lines,max-1,target);
        }
        else{
//            lines.get(line_max).remove(max);
            return solution(lines,max-1,3-target-line_max)+1+f(max-1);
        }
    }

    private static int f(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            res=res*2+1;
        }
        return res;
    }
}
