package algorithm.code.nyoj.nyoj12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  tips:
 *  java中double类型的比较使用Double.compare
 */
public class Main {
    public static List<Line> lists= new ArrayList<Line>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj12.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        lists.clear();
        int n = cin.nextInt();
        int w=cin.nextInt();
        int h = cin.nextInt();
        for(int i=0;i<n;i++){
            int center=cin.nextInt();
            int radis = cin.nextInt();
            trans(center,radis,w,h);
        }
        Collections.sort(lists, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return Double.compare(o1.begin, o2.begin);
            }
        });
        int i=0;
        int num=0;
        double rightest=0;
        double cur=0;
        while(cur<w) {
            while (i<lists.size() && lists.get(i).begin <= rightest) {
                if (lists.get(i).end > cur) cur = lists.get(i).end;
                i++;
            }
            if(cur>rightest) {
                rightest = cur;
                num++;
            }
            else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(num);
    }

    private static void trans(int center, int radis, int w, int h) {
        double y=h/2.0;
        if(radis*radis - y*y<0) return;
        double x = Math.sqrt(radis*radis - y*y);
        Line line = new Line(center-x>0?center-x:0,center+x<w?center+x:w);
        lists.add(line);
    }

    public static class Line{
        double begin;
        double end;

        public Line(double begin, double end) {
            this.begin = begin;
            this.end = end;
        }
    }
}
