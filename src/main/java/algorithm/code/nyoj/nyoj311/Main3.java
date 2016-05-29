package algorithm.code.nyoj.nyoj311;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/nyoj311.txt"));
        StringTokenizer st;
        int type; //种类
        int volume; //总容量
        int i,j;
        int[] w, v; //重量 、价钱
        int[] dp;

        st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        while(total-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            type = Integer.parseInt(st.nextToken());
            volume = Integer.parseInt(st.nextToken());

            v = new int[type + 1];
            w = new int[type + 1];
            dp = new int[volume + 1];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[0] = 0;

            for(i = 1; i <= type; i++)
            {
                st = new StringTokenizer(br.readLine());
                w[i] = Integer.parseInt(st.nextToken());
                v[i] = Integer.parseInt(st.nextToken());
            }

            for(i = 1; i <= type; i++)
            {
                for(j = w[i]; j <= volume; j++)
                {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }

            System.out.println(dp[volume] <= 0 ? "NO" : dp[volume]);
        }


    }

}

