package algorithm.code.nyoj.nyoj78;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 也是GiftWrapping算法
 */
public class Main_other {

    //代表一个节点
    public static class point implements Comparable{
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Object o) {
            if(o instanceof point){
                point b=(point)o;
                if (x < b.x||(x==b.x) && (y<b.y)){
                    return -1;
                }
                else{
                    return 1;
                }
            }
            return 1;
        }
    }

    static point p[],pin[];
    static Scanner scanner;

    static {
        try {
            scanner = new Scanner(new FileInputStream("src/main/resources/nyoj78.txt"), "utf8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //给三个点，判断是否是逆时针
    public static boolean pd(point a,point b,point c){
        if( (b.x-a.x)*(c.y-a.y) - (c.x-a.x)*(b.y-a.y)>0){
            return true;
        }
        return false;
    }

    //开始进行做排除法
    public static int PX(){
        int zx=0;//表示pin中有多少个值
        Arrays.sort(p);
        for(int i=0;i<p.length;pin[zx++]=p[i++]){
            while(zx>=2&&pd(pin[zx-2],pin[zx-1],p[i])){
                zx--;
            }
        }
        for(int i=p.length-1,m=zx+1;i>=0;pin[zx++]=p[i--]){
            while(zx>=m&&pd(pin[zx-2],pin[zx-1],p[i])){
                zx--;
            }
        }
        return --zx;
    }

    //输入,v是有多少个坐标
    public static void init(int v){
        pin=new point[v*2];
        p=new point[v];
        for(int i=0;i<v;i++){
            p[i]=new point(scanner.nextInt(),scanner.nextInt());
        }
    }

    //将pin[]按照给定的顺序排序，最后输出
    public static void output(int k){
        //排序
        Arrays.sort(pin, 0, k);
        //----------------
        for(int i=0;i<k-1;i++){
            System.out.println(pin[i].x+" "+pin[i].y);
        }
    }
    public static void main(String[] arg){
        int k=scanner.nextInt();
        while(k-->0){
            int n=scanner.nextInt();
            init(n);
            int mm=PX();
            output(mm);
        }

    }
}
