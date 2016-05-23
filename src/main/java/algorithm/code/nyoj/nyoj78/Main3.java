package algorithm.code.nyoj.nyoj78;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  凸包经典问题
 *  Graham Scan算法
 *  注意： 叉积的感念 以及 叉积用来判断直线的位置关系
 *  Compartor接口的return正负的含义
 *
 *
 *  编程中的疑点：
 *  1 起点从哪儿选
 *  2 第二个点，第三个点与起点在同一直线上如何处理
 *  3 排序时如何把起点排在第一位（解决方案是起点不参与排序）
 */
public class Main3 {
    public static List<Point> stack = new ArrayList<Point>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
        cin = new Scanner(new FileInputStream("src/main/resources/nyoj78.txt"),"utf8");
//        cin = new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int N = cin.nextInt();
        Point[] points = new Point[N];
        int min_points = 0;
        for(int i=0;i<N;i++){
            points[i] =new Point(cin.nextInt(),cin.nextInt());
            if(points[min_points].y > points[i].y || (points[min_points].y == points[i].y && points[min_points].x > points[i].x)){
                min_points = i;
            }
        }

        Point temp = points[0];
        points[0]=points[min_points];
        points[min_points] = temp;
        final Point start= points[0];
        Arrays.sort(points,1,N, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int cross = (o2.x-start.x)*(o1.y-start.y) - (o2.y-start.y)*(o1.x-start.x);
                if(cross!=0)return cross;
                return (int) (distance(o1,start) - distance(o2,start));
            }

            private double distance(Point o1, Point o2) {
               return Math.sqrt((o2.x-o1.x)*(o2.x-o1.x)+(o2.y-o1.y)*o2.y-o1.y);
            }
        });
        solution(points,points.length);
    }

    private static void solution(Point[] points,int len) {
        if(len==0 || len ==1|| len == 2){
            return;
        }
        stack.clear();
        stack.add(points[0]);
        stack.add(points[1]);
        for(int i=2;i<len;i++){
            Point p1 = stack.get(stack.size()-1);
            Point p2 = stack.get(stack.size()-2);
            while ((points[i].y-p1.y)*(p1.x-p2.x) - (points[i].x-p1.x)*(p1.y-p2.y) <= 0){
                stack.remove(stack.size()-1);
                if(stack.size()==1) break;
                p1 = p2;
                p2 = stack.get(stack.size() - 2);
            }
            stack.add(points[i]);
        }
        Collections.sort(stack, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x-o2.x!=0) return o1.x-o2.x;
                else return o1.y-o2.y;
            }
        });
        for(int i=0;i<stack.size();i++){
            System.out.println(stack.get(i).x+" "+stack.get(i).y);
        }
//        while(!stack.isEmpty()){
//            Point p =stack.pop();
//            System.out.println(p.x + " "+ p.y);
//        }
    }
    public static class Point{
        int x;
        int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
