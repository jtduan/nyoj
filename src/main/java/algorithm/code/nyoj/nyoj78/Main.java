package algorithm.code.nyoj.nyoj78;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  GiftWrapping算法
 */
public class Main {
    public static List<Point> list = new ArrayList<Point>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
        cin = new Scanner(new FileInputStream("src/main/resources/nyoj78.txt"),"utf8");
//        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int N = cin.nextInt();
        Point[] points = new Point[N];
        int min_points = 0;
        for(int i=0;i<points.length;i++){
            points[i]=new Point(cin.nextInt(),cin.nextInt());
            if(points[min_points].y > points[i].y || (points[min_points].y == points[i].y && points[min_points].x > points[i].x)){
                min_points = i;
            }
        }
        list.clear();
        list.add(points[min_points]);
        while(true){
            Point p =findRightest(points,list.get(list.size()-1));
            if(p!=list.get(0)){
                list.add(p);
            }
            else break;
        }
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x-o2.x!=0) return o1.x-o2.x;
                else return o1.y-o2.y;
            }
        });
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).x+" "+ list.get(i).y);
        }
    }

    private static Point findRightest(Point[] points,Point cur) {
        Point rightest=points[0];
        for(int i=0;i<points.length;i++){
            if((rightest.x-cur.x)*(points[i].y-cur.y) - (rightest.y-cur.y)*(points[i].x-cur.x) < 0
                    || ((rightest.x-cur.x)*(points[i].y-cur.y) - (rightest.y-cur.y)*(points[i].x-cur.x) == 0
                    && distance(rightest,cur) - distance(points[i],cur) < 0)){
                rightest = points[i];
            }
        }
        return rightest;
    }

    private static int distance(Point rightest, Point point) {
        return (rightest.x-point.x)*(rightest.x-point.x)+(rightest.y-point.y)*(rightest.y-point.y);
    }

}
class Point{
    int x;
    int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}