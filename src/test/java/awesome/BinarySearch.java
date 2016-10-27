package awesome;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author jtduan
 * @date 2016/10/26
 * 二分查找
 * Collections.binarySearch()函数找到的某一个index不一定位于两端
 * 若需要找到位于某一端的index，需要自己实现二分查找函数
 *
 *
 * 写法注意事项：
 * 1　return start 或 end,左侧start，右侧end
 * 2 mid 与target相等时 继续判断（找边界，左边界 移动end,右边界移动start)，
 * 每次移动至少删除一个元素，不出现 start=mid 或者end=mid情况
 * 3 求mid 使用start+(end-start)/2防止溢出
 */
public class BinarySearch {

    /**
     * 递归写法
     */
    public static int binarySearch(int[]nums,int low,int high,int target){
        if(low>high) throw new RuntimeException();
        int mid = low+(high-low)/2;
        if(low==high){
            return nums[low]==target?low:-low-1;
        }
        if(nums[mid]>=target){
            return binarySearch(nums,low,mid-1,target);
        }else{
            return binarySearch(nums,mid+1,high,target);
        }
    }


    /**
     * 推荐写法，可以查找到边界
     * 返回前判断nums[start]是否与target相同
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return nums[start]==target?start:-start-1;
    }

    public static int binarySearch2(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return end;
    }

    @Test
    public void testFindIndex(){
        int[] nums = new int[]{2,3,3,3,3,8};
        System.out.println(binarySearch(nums,3));
        System.out.println(binarySearch(nums,0,nums.length-1,3));
    }
}
