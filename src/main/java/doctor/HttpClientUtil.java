package doctor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class HttpClientUtil {
    public static final String loginURL = "http://www.bjguahao.gov.cn/quicklogin.htm";  //先登录保存cookie
    public static final String getDoctorURL = "http://www.bjguahao.gov.cn/dpt/partduty.htm";
    public static final String OrderUrl = "http://......";
    public String sessionId = "";

    public void doLogin() throws IOException{
        String key = "";
        String cookieVal = "";
        URL url = new URL(loginURL);
        System.setProperty("http.keepAlive", "false");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true); //设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
        connection.setRequestMethod("POST"); // 设置请求方式为post
        connection.setUseCaches(false); // post请求缓存设为false
        connection.connect(); //到此步只是建立与服务器的tcp连接，并未发送http请求


        // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
        DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
        String parm = "mobileNo=18141920147&password=djt178508529&yzm=&isAjax=true"; //+ URLEncoder.encode("32", "utf-8"); //URLEncoder.encode()方法  为字符串进行编码
        dataout.writeBytes(parm);
        dataout.flush();
        dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)

        /**
         * 设置cookie
         */
        if(!sessionId.equals("")){
            connection.setRequestProperty("Cookie", sessionId);
        }
        for(int i=1;(key=connection.getHeaderField(i))!=null;i++){
            cookieVal = connection.getHeaderField(i);
            cookieVal = cookieVal.substring(0,cookieVal.indexOf(";")>-1?cookieVal.indexOf(";"):cookieVal.length()-1);
            sessionId = sessionId + cookieVal + ";";
        }

        //直到getInputStream()方法调用请求才真正发送出去
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
        connection.disconnect();
    }

    public void doPost() throws IOException{
        String key = "";
        String cookieVal = "";
        System.setProperty("http.keepAlive", "false");
        URL url = new URL(getDoctorURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true); //设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)
        connection.setRequestMethod("POST"); // 设置请求方式为post
        connection.setUseCaches(false); // post请求缓存设为false
        connection.connect(); //到此步只是建立与服务器的tcp连接，并未发送http请求


        // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
        DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
        String parm = "hospitalId=142&departmentId=200039538&dutyCode=2&dutyDate=2016-11-30&isAjax=true"; //+ URLEncoder.encode("32", "utf-8"); //URLEncoder.encode()方法  为字符串进行编码

        dataout.writeBytes(parm);
        dataout.flush();
        dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)

        /**
         * 设置cookie
         */
        if(!sessionId.equals("")){
            connection.setRequestProperty("Cookie", sessionId);
        }

        //直到getInputStream()方法调用请求才真正发送出去
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=br.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
        connection.disconnect();
    }

    public static void main(String[] args) throws IOException {
        HttpClientUtil hcu = new HttpClientUtil();
        hcu.doLogin();
//        hcu.doPost();
    }
}
