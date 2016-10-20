package algorithm.code.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jtduan
 * @date 2016/10/19
 */
public class L403 {
    public boolean canCross(int[] stones) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Set<Integer> init = new HashSet<>();
        init.add(0);
        init.add(1);
        map.put(0,init);
        for(int i=1;i<stones.length;i++){
            map.put(i,new HashSet<>());
            for(int j=0;j<i;j++) {
                if (map.get(j).contains(stones[i]-stones[j])){
                    map.get(i).add(stones[i]-stones[j]);
                    map.get(i).add(stones[i]-stones[j]+1);
                    map.get(i).add(stones[i]-stones[j]-1);
                }
            }
        }
        if(map.get(stones.length-1).isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L403().canCross(new int[]{0,1,2,3,4,8,9,11}));
    }
}
