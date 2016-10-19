package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jtduan
 * @date 2016/10/19
 */
public class L137 {
    public int singleNumber(int[] nums) {
        int[] bits =new int[32];
        for(int i=0;i<32;i++){
            bits[i]=0;
        }

        for(int num:nums) {
            update(bits,num);
        }
        int res=0;
        for(int i=0;i<32;i++){
            if(bits[i]%3!=0) res+=(1<<i);
        }
        return res;
    }

    private void update(int[] bits, int num) {
        for(int i=0;i<32;i++){
            if(((num>>i) & 1) ==1){
                bits[i]++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new L137().singleNumber(new int[]{123,123,123,345}));
        String str ="";
        List<String> list = new ArrayList<>();
        list.stream().distinct().collect(Collectors.toList());
    }
}
