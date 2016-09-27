package algorithm.code.pathes;

import java.util.*;

/**
 * Created by hero on 2016/5/25.
 * A*算法
 * h()为 距离目标点的“距离”
 * g()为已经移动的步数（不是距离）
 * 每当g()增加1时，h()降低小于等于1，则可以保证能够找到最优解，否则不一定找到最优解
 *
 * 原理：每次寻找已经经过的点集边缘f()=h()+g()最小的点，扩大该点积（这样会优先向目标点扩展，
 * 因为每次扩展h()一定要增大，但向目标点扩展g()会变小），当g'()远大于h'()时（
 * 就是每次向目标点移动后，f()会下降很多），则变为贪心算法
 *
 * 数据结构，本算法 使用了优先队列，每次取出权值f最小的点，(插入时仍然需要遍历判断是否已经在队列中，
 * 因此也可以自己实现排序的ArrayList,快速判断，或者增加额外的map存储是否在优先队列)，扩展该点之后将该点标记为不可达（2）
 * 再从队列中取出新的f最小的点，以此类推
 *
 * 每个Point结构会存储上一跳Point(用于结束时打印路径)
 *
 * 本算法使用欧几里得路径（距离目标的直线距离，因此g'()*1.414 = f'(),）
 */
public class A {
    // 地图描述
    final static public int[][] map = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

    PriorityQueue<Point> queue= new PriorityQueue<Point>(new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.f-o2.f>0?1:-1;
        }
    });

    Point end;

    Point start;

    public A(int x1,int y1,int x2,int y2) {
        start =new Point(x1,y1,(Math.abs(x2-x1)+Math.abs(y2-y1)));
        end =new Point(x2,y2,0);
    }

    public void findMin(){
        queue.add(start);

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            map[cur.x][cur.y]=2;
            if(cur.x == end.x && cur.y == end.y){
                int i=0;
                while(cur!=null){
                    map[cur.x][cur.y] = 10+(i++);
                    cur = cur.parent;
                }
                printMap();
                return;
            }
            around(cur);
        }
    }

    private void printMap() {
        for( int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                System.out.printf("%4d",map[i][j]);
            }
            System.out.println();
        }
    }

    private void around(Point cur) {
        if(cur.x-1>=0 && map[cur.x-1][cur.y]==0){
            updateQueue(new Point(cur.x-1,cur.y,cur));
//            queue.add(new Point(cur.x-1,cur.y,cur.g+100,cur));
//            map[cur.x-1][cur.y]=2;
        }
        if(cur.x+1<map.length && map[cur.x+1][cur.y]==0){
            updateQueue(new Point(cur.x+1,cur.y,cur));
        }
        if(cur.y-1>=0 && map[cur.x][cur.y-1]==0){
            updateQueue(new Point(cur.x,cur.y-1,cur));
        }
        if(cur.y+1<map[0].length && map[cur.x][cur.y+1]==0){
            updateQueue(new Point(cur.x,cur.y+1,cur));
        }
    }

    private void updateQueue(Point point) {
        Iterator<Point> it = queue.iterator();
        while(it.hasNext()){
            Point p =it.next();
            if(p.equals(point) && p.f>point.f){
                p.f = point.f;
                p.parent = point.parent;
                return;
            }
        }
        queue.add(point);
    }

    public static void main(String[] args) {
        A a = new A(3,2,8,8);
        a.findMin();
    }

    class Point{
        int x;
        int y;
        Point parent;
        int g;
        int h;
        int f;

        public Point(int x, int y,Point parent) {
            this.x = x;
            this.y = y;
            this.g = parent.g+10;  // 每次g' =10
            this.parent = parent;
            this.h = distance(end);
            this.f = this.g+this.h;
        }

        public Point(int x, int y,int f) {
            this.x = x;
            this.y = y;
            this.f = f;
        }

        private int distance(Point target) {
            /**
             * 此处*14以上将可能不能找到最短路径
             * *100几乎就是贪心算法
             * *0就是Dijkstra算法
             */
            return (int)(Math.sqrt((target.x-this.x)*(target.x-this.x)+(target.y-this.y)*(target.y-this.y))*10);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
