package test;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by hero on 2016/9/2.
 */
public class Main {
    public static void main(String[] args) {
        String str = ReadFile.txt2String(new File("src/main/resources/aaa"));
        JSONObject root = JSONObject.fromObject(str);
        for(Object obj:root.getJSONArray("awardList")){
            for(Object subboj : ((JSONObject)obj).getJSONArray("jcMatchOdds")){
                System.out.println(((JSONObject)subboj).getString("matchKey"));
            };
        }
    }
}

class ReadFile {
    /**
     * 读取txt文件的内容
     *
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}