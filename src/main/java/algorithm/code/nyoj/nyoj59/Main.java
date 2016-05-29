package algorithm.code.nyoj.nyoj59;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  nyoj模板代码
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj59.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int n = cin.nextInt();
        int[][] user = new int[n][2];
        for(int i=0;i<n;i++){
            user[i][0]=cin.nextInt()-1;
            user[i][1]=cin.nextInt()-1;
        }
        System.out.println(solution(user,user.length));
    }

    private static int solution(int[][] user,int n) {
        if(n<=3)return 0;
        int cur[]= new int[n];
        cur[1]=0;
        cur[0]=user[0][0];
        cur[2]=user[0][1];
        int cur_i=2;
        int[] flag=new int[n];
        while(cur_i!=n-1){
            int first=cur[cur_i];
            if(user[first][0]==cur[cur_i-1]) {
                cur[++cur_i]=user[first][1];
            }
            else if(user[first][1]==cur[cur_i-1]) {
                cur[++cur_i]=user[first][0];
            }
            else return -1;
        }
        if((user[cur[0]][1]==cur[cur_i] || user[cur[0]][0]==cur[cur_i])
                && (user[cur[cur_i]][1]==cur[0] || user[cur[cur_i]][0]==cur[0])){
            return solution2(cur,user.length);
        }
//        cur[0]=0;
//        for (int i=1;i<n;i++)
//        {
//            if(flag[user[cur[i-1]][0]]==0)
//            {
//                cur[i]=user[cur[i-1]][0];
//                flag[cur[i-1]]=1;
//            }else if(flag[user[cur[i-1]][1]]==0)
//            {
//                cur[i]=user[cur[i-1]][1];
//                flag[cur[i-1]]=1;
//            }
//            else {return -1;}
//        }
//        if((user[cur[n-1]][0]==0 ||user[cur[n-1]][1]==0 )&& (user[0][0]==cur[n-1] ||user[0][1]==cur[n-1])){
//            return solution2(cur,user.length);
//        }
        return -1;
    }

    private static int solution2(int[] users1,int n) {

        int max1 = 0;
        int max2 = 0;
        int[] users2=new int[n];
        int[] distance = new int[n];
        int[] distance2 = new int[n];
        for(int i=n-1;i>=0;i--){
            users2[i]=users1[n-1-i];
        }

        for(int i=0;i<n;i++){
            distance[(n+users1[i]-i)%n]++;
            distance2[(n+users2[i]-i)%n]++;
        }
        for(int i=0;i<n;i++){
            if(max1<distance[i]){
                max1=distance[i];
            }
            if(max2<distance2[i]){
                max2=distance2[i];
            }
        }
        return n - Math.max(max2,max1);
    }
}
