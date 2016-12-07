package algorithm.code.niuke;

/**
 * 难度：4
 * 小易是一个数论爱好者，并且对于一个数的奇数约数十分感兴趣。一天小易遇到这样一个问题： 定义函数f(x)为x最大的奇数约数，x为正整数。 例如:f(44) = 11.
 * 现在给出一个N，需要求出 f(1) + f(2) + f(3).......f(N)
 * 例如： N = 7
 * f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
 * 小易计算这个问题遇到了困难，需要你来设计一个算法帮助他。
 * f(21) = 21;
 *
 * 思路：f(奇数）=该奇数
 * f(偶数）=f(该偶数/2)
 * n*n/4 = 1+3+5+....+n-1;
 */
public class NetEase6 {

    public static int solution(int n) {
        if(n%2==0){
            return solution(n/2)+n*n/4;
        }
        else{
            return solution(n-1)+n;
        }
    }
}
