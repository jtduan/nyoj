package algorithm.code.bitree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/*
 * Java语言 树状数组 求区间最大值 模板代码
 * Created by hero on 2016/5/10.
 */

public class BITree{
    public int[] tree;
    public int[] origin;

    public BITree(int[] origin,BiFunction<Integer,Integer,Integer> f) {
        this.tree = Arrays.copyOf(origin, origin.length);
        this.origin = origin;
        Init(f);
    }

    private void Init(BiFunction<Integer,Integer,Integer> f){
        for(int i=1;i< origin.length;i++){
            tree[i]=origin[i];
            for(int j=1;j<Lowbit(i);j<<=1){
                //tree[i]=Math.max(tree[i],tree[i-j]);
                tree[i]=f.apply(tree[i],tree[i-j]);
            }
        }
    }

    void update(int p,int v,BiFunction<Integer,Integer,Integer> f){
        origin[p]=v;
        for(int i=p;i<origin.length;i+=Lowbit(i)){
            tree[i]=v;
            for(int j=1;j<Lowbit(i);j<<=1){
                tree[i]=f.apply(tree[i],tree[i-j]);
            }
        }
    }

    public int query(int l, int r,BinaryOperator<Integer> f) {
        List<Integer> numbers =new ArrayList<Integer>();
        int ans=origin[r];
        while(true){
            numbers.add(origin[r]);
//            ans=Math.max(ans,origin[r]);
            if(r==l) break;
            for(r-=1;r-l>=Lowbit(r);r-=Lowbit(r)){
//                ans=Math.max(ans,tree[r]);
                numbers.add(tree[r]);
            }
        }
        Optional<Integer> optional= numbers.stream().reduce(f);
        return optional.get();
    }

    private int Lowbit(int bit) {
        return bit & (-bit);
    }

    public static void main(String[] args) {
        int nums[]=new int[]{0,8,4,7,19,9,2,8,55,5,4};
        BITree bi=new BITree(nums,(a,b) -> a+b);
        bi.update(2,22,(a,b)->a+b);
        int l=3;
        int r=10;
        int sum=0;
        for(int i=l;i<=r;i++){
            sum+=nums[i];
        }
        System.out.println(bi.query(l,r,(a,b) -> a+b)+"===="+sum);
        for(int i=0;i<=bi.origin.length-1;i++){
            System.out.print(bi.tree[i]+ " ");
        }

        System.out.println(6 & -6);
    }
}
