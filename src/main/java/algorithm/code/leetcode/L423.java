package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/1
 */
public class L423 {
    public String originalDigits(String s) {
        char[] chars = s.toCharArray();
        int[] num = new int[26];
        for(char ch:chars){
            num[ch-'a']++;
        }
        int[] res = new int[10];
        res[0]=num['z'-'a'];
        num['z'-'a']=0;
        num['e'-'a']-=res[0];
        num['r'-'a']-=res[0];
        num['o'-'a']-=res[0];

        res[2]=num['w'-'a'];
        num['w'-'a']=0;
        num['t'-'a']-=res[2];
        num['o'-'a']-=res[2];

        res[4]=num['u'-'a'];
        num['u'-'a']=0;
        num['f'-'a']-=res[4];
        num['o'-'a']-=res[4];
        num['r'-'a']-=res[4];

        res[5]=num['f'-'a'];
        num['f'-'a']=0;
        num['i'-'a']-=res[5];
        num['v'-'a']-=res[5];
        num['e'-'a']-=res[5];

        res[8]=num['g'-'a'];
        num['g'-'a']=0;
        num['e'-'a']-=res[8];
        num['i'-'a']-=res[8];
        num['h'-'a']-=res[8];
        num['t'-'a']-=res[8];

        res[1]=num['o'-'a'];
        num['o'-'a']=0;
        num['n'-'a']-=res[1];
        num['e'-'a']-=res[1];

        res[6]=num['x'-'a'];
        num['x'-'a']=0;
        num['i'-'a']-=res[6];
        num['s'-'a']-=res[6];

        res[9]=num['i'-'a'];
        num['i'-'a']=0;
        num['n'-'a']-=2*res[9];
        num['e'-'a']-=res[9];

        res[7]=num['s'-'a'];
        num['s'-'a']=0;
        num['e'-'a']-=2*res[7];
        num['v'-'a']-=res[7];
        num['n'-'a']-=res[7];

        res[3]=num['h'-'a'];
        num['h'-'a']=0;
        num['e'-'a']-=2*res[3];
        num['t'-'a']-=res[3];
        num['r'-'a']-=res[3];

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=9;i++){
            for(int j=0;j<res[i];j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new L423().originalDigits("ereht"));
    }
}
