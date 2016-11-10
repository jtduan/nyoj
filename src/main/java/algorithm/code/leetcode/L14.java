package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/10
 */
public class L14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        int len=Integer.MAX_VALUE;
        for(String str:strs){
            len=Math.min(str.length(),len);
        }
        for(int i=0;i<len;i++){
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)==strs[j-1].charAt(i))continue;
                return strs[0].substring(0,i);
            }
        }
        return strs[0].substring(0,len);
    }
}
