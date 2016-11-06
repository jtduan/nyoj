package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hero on 2016/9/2.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        String str = ReadFile.txt2String(new File("src/main/resources/aaa"));
//        JSONObject root = JSONObject.fromObject(str);
//        for(Object obj:root.getJSONArray("awardList")){
//            for(Object subboj : ((JSONObject)obj).getJSONArray("jcMatchOdds")){
//                System.out.println(((JSONObject)subboj).getString("matchKey"));
//            };
//        }
        List<Obj> list = new ArrayList<>();
        int i=0;
        while(true){
            list.add(new Obj(++i));
            Thread.sleep(1);
        }
    }
    static class Obj{
        int val;
        Double p;
        Set<Integer> set = new HashSet<>();

        public Obj(int val) {
            this.val = val;
            set.add(1);
            set.add(7);
        }
    }
}

//class ReadFile {
//    /**
//     * 读取txt文件的内容
//     *
//     * @param file 想要读取的文件对象
//     * @return 返回文件内容
//     */
//    public static String txt2String(File file) {
//        StringBuilder result = new StringBuilder();
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
//            String s = null;
//            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
//                result.append(s);
//            }
//            br.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result.toString();
//    }
//}