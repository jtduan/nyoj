package algorithm.code.niuke;

import org.junit.Assert;
import org.junit.Test;

/**
 * 难度：0
 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 * 例如：半径的平方如果为25
 * 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
 */
public class NetEase2 {
    @Test
    public void test() {
        Assert.assertEquals(12, solution(25));
    }

    public static int solution(int r) {
        int res = 0;
        for (int i = 0; i * i < r; i++) {
            int h = (int) Math.sqrt(r - i * i);
            if (h * h + i * i == r) {
                res += 4;
            }
        }
        return res;
    }
}
