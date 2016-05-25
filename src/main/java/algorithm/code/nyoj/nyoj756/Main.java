package algorithm.code.nyoj.nyoj756;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  重建二叉树
 *  二叉树的后序和中序序列，求出它的前序序列
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj786.txt"),"utf8");
        cin = new Scanner(System.in);
        while(cin.hasNext()){
            String str = cin.nextLine();
            solution(str.split(" ")[0],str.split(" ")[1]);
            System.out.println();
        }
    }

    private static void solution(String str1,String str2) {
        if(str1.length()==0){
            return;
        }
        char ch=str1.charAt(str1.length()-1);
        System.out.print(ch);
        int index =str2.indexOf(ch);
        solution(str1.substring(0,index),str2.substring(0,index));
        solution(str1.substring(index,str1.length()-1),str2.substring(index+1));
    }
}
