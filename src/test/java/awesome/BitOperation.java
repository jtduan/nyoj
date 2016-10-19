package awesome;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jtduan
 * @date 2016/10/19
 * 位运算基本算法
 */
public class BitOperation{
    /**
     * 交换两个变量,不使用临时变量
     * 位运算的规律：如果a^b=c,则a^c=b
     * @param a
     * @param b
     */
    public void swap(int a,int b){

        /**
        int c=a^b;
        b=c^b; b的值被赋值为a
        a=c^b; 相当于 c^原来的a, 被赋值为a,交换了a,b
         **/

        a=a^b;
        b=a^b;
        a=a^b;
    }


    /**
     * 不用加法做两个数的和
     * a^b为不带进位的a+b
     * a&b为各个仅为，<<1是进位后的大小
     * 循环对上面2个值进行相加，直到进位为0
     * 时间复杂的O(logn)
     * a,b可以为负数
     *
     * 可以扩展为不用减法做差
     */
    public int add(int a,int b){
        while(b!=0){
            int temp=a^b;
            b=(a&b)<<1;
            a = temp;
        }
        return a;
    }

    /**
     * 求负数
     * ~为按位取反
     * a需要大于0，才可以运算出正确的结果
     */
    public int func(int a){
        return ~a+1;
    }

    /**
     * 求绝对值
     * ~为按位取反
     * 才可以运算出正确的结果
     */
    public int abs(int a){
        int i = a >> 31; //判断a的符号位
        return i == 0 ? a : (~a + 1);
        /**
         * 或者这样，不使用if
         *   return ((a ^ i) - i);
         *   原理： i=0（正数）时，a^0-0 =a
         *   i=-1时（负数）a^-1相当于取反
         *   注意：负数右移31位得到的值为-1而不是1！,负数右移时，高位补1
         */
    }

    /**
     * 统计二进制中1的个数
     * a&(a-1)为删除二进制中末尾的100..后的值
     * @param a
     * @return
     */
    public int count1(int a){
        int res =0;
        while(a!=0){
            a=a&(a-1);
            res++;
        }
        return res;
    }

    /**
     * 求两个数的平均值
     * @param a
     * @param b
     * @return
     * 原理，当a的某一位与b的某一位不同(01)时，a&b=0,(a^b)>>1相当于除以2
     * 为(00)时 a&b=0,(a^b)>>1 =0;
     * 为(11)时 a&b=1,(a^b)>>1 =0; 不影响该位
     *
     */
    public int avg(int a,int b){
        return (a&b) + ( (a^b)>>1 );
    }

    /**
     * 其他类型：
     * 1统计出现奇数次（其他偶数）的某一个数，异或
     * 2统计出现未出现n的倍数次的一个数（其他出现n的倍数）：通过统计每一位的出现次数
     * 3统计出现奇数次的某2个数：将数组分隔成2部分，每部分符合1所示的类型，根据整个数组异或结果的某一位为1的位进行重新hash（Leetcode260）
     */

    @Test
    public void testAdd(){
        Assert.assertEquals(10,add(4,6));
        Assert.assertEquals(78736,add(50000,28736));
        Assert.assertEquals(-73333,add(-50000,-23333));
    }
    @Test
    public void testFunc(){
        Assert.assertEquals(-73333,func(73333));
    }
    @Test
    public void testCount1(){
        Assert.assertEquals(4,count1(15));
    }
    @Test
    public void testAvg(){
        Assert.assertEquals(4,avg(1,7));
        Assert.assertEquals(4,avg(1,8));
        Assert.assertEquals(3,avg(-1,8));
    }
    @Test
    public void testAbs(){
        Assert.assertEquals(82,abs(-82));
        Assert.assertEquals(162,abs(162));
    }
}
