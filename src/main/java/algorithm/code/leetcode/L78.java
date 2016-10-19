package algorithm.code.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author jtduan
 * @date 2016/10/19
 */
public class L78 {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0){
            List list = new ArrayList();
            list.add(new ArrayList<Integer>());
            return list;
        }
        List<List<Integer>> sub_lists = subsets(Arrays.copyOf(nums,nums.length-1));
        Iterator<List<Integer>> it = sub_lists.iterator();
        List<List<Integer>> list = new ArrayList();
        while(it.hasNext()){
            List<Integer> temp = it.next();
            List<Integer> l1=new ArrayList<Integer>();
            List<Integer> l2=new ArrayList<Integer>();
            l1.addAll(temp);
            l2.addAll(temp);
            l1.add(nums[nums.length-1]);
            list.add(l1);
            list.add(l2);
        }
        return list;
    }
}
