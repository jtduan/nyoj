package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/26
 */
public class L421 {
    public int findMaximumXOR(int[] nums) {
        if(nums.length==0||nums.length==1) return 0;
        Node root = new Node();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            add(root,nums[i]);
            int temp = ~nums[i];
            int j = getMax(root,temp);
            max = Math.max(j,max);
        }
        return max;
    }

    private int getMax(Node root, int num) {
        int res=0;
        for(int i=31;i>=0;i--){
            if((num>>i & 1)==1){
                if(root.l==null)root=root.r;
                else{
                    root=root.l;
                    res|=(1<<i);
                }
            }else{
                if(root.r==null) root=root.l;
                else{
                    root=root.r;
                    res|=(1<<i);
                }
            }
        }
        return res;
    }

    private void add(Node root, int num) {
        for(int i=31;i>=0;i--){
            if((num>>i & 1)==1){
                if(root.l==null) root.l = new Node();
                root=root.l;
            }else{
                if(root.r==null) root.r=new Node();
                root=root.r;
            }
        }
    }

    class Node{
        Node l;
        Node r;
    }

    public static void main(String[] args) {
        System.out.println(new L421().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
