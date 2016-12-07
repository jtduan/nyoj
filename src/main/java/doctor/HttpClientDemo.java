package doctor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Scanner;

/**
 * 使用须知：
 * 1. 需要首先创建病人，并获取patientId(通过查看源代码：<input type="radio" name="hzr" value="***" checked="checked"> )
 * value即为patinentId
 * 2 存在多个就诊人时，第一个为待预约就诊人
 * 3 需要找到待预约的医院Id和科室Id(通过进入医院详情页面查看源代码：<a class="kfyuks_islogin" href="/dpt/appoint/142-200039598.htm">眼科门诊</a>)
 * 142-200039598 即为医院Id-科室Id
 * <p>
 * 4
 */
public class HttpClientDemo {
    public static final String loginURL = "http://www.bjguahao.gov.cn/quicklogin.htm";
    public static final String getDoctorURL = "http://www.bjguahao.gov.cn/dpt/partduty.htm";
    public static final String confirmUrl = "http://www.bjguahao.gov.cn/order/confirm.htm";
    public static final String verifyCodeURL = "http://www.bjguahao.gov.cn/v/sendorder.htm";

    public static int verfiyCode = 312945;
    public static CookieStore cookieStore = new BasicCookieStore();

    public static final String userName = "18141920147";
    public static final String userPwd = "djt178508529";

    public static final String date = "2016-12-05";
    public static final String duty = "2";
    public static final String hospitalId = "142";
    public static final String departmentId = "200039542";

    public static final String patientId = "229926864";

    public static String doctorId = "";
    public static String dutySourceId = "";

    public static boolean doLogin() throws IOException {
        String params = "mobileNo=" + userName + "&password=" + userPwd + "&yzm=&isAjax=true";
        String res = send(loginURL, params);
        System.out.println("登录结果：" + res);
        return res.contains("\"code\":200");
    }

    private static boolean loadDoctor() throws IOException {
        String params = "hospitalId=" + hospitalId + "&departmentId=" + departmentId + "&dutyCode=" + duty + "&dutyDate=" + date + "&isAjax=true";
        String res = send(getDoctorURL, params);
        return buildOrderUrl(res);
    }

    private static boolean buildOrderUrl(String response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(response);
        JsonNode data = node.get("data");
        for (int i = data.size() - 1; i >= 0; i--) {
            if (data.get(i).get("remainAvailableNumber").asInt() > 0) {
                doctorId = data.get(i).get("doctorId").asText();
                dutySourceId = data.get(i).get("dutySourceId").asText();
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        doLogin();
//        while (true) {
//            if (loadDoctor()) {
//                break;
//            }
//            Thread.sleep(100);
//        }
//        if (verfiyCode == 0) {
//            if (doSendVerfiCode()) {
//                System.out.println("true");
//            } else {
//                System.out.println("false");
//            }
//            Scanner scanner = new Scanner(System.in);
//            verfiyCode = scanner.nextInt();
//        }
//        doPreOrder();
    }

    private static boolean doPreOrder() throws IOException {
        String[] params = new String[15];
        params[0] = "dutySourceId=" + dutySourceId;
        params[1] = "hospitalId=" + hospitalId;
        params[2] = "departmentId=" + departmentId;
        params[3] = "doctorId=" + doctorId;
        params[4] = "patientId=" + patientId;
        params[5] = "hospitalCardId=";
        params[6] = "medicareCardId=";
        params[7] = "reimbursementType=-1";
        params[8] = "smsVerifyCode=" + verfiyCode;
        params[9] = "isFirstTime=2";
        params[10] = "hasPowerHospitalCard=2";
        params[11] = "cidType=1";
        params[12] = "childrenBirthday=";
        params[13] = "childrenGender=2";
        params[14] = "isAjax=true";
        String res = send(confirmUrl, String.join("&", params));
        System.out.println("预约结果：" + res);
        return res.contains("\"code\":200");
    }

    private static boolean doSendVerfiCode() throws IOException {
        String res = send(verifyCodeURL, "");
        System.out.println("验证码发送结果：" + res);
        return res.contains("\"code\":200");
    }

    private static String send(String url, String params) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpClientContext localContext = HttpClientContext.create();
            localContext.setCookieStore(cookieStore);
            HttpPost post = new HttpPost(url);

            StringEntity stringEntity = new StringEntity(params, "UTF-8");
            stringEntity.setContentType("application/x-www-form-urlencoded");
            post.setEntity(stringEntity);

            try (CloseableHttpResponse response = httpclient.execute(post, localContext)) {
                String responseBody = EntityUtils.toString(response.getEntity());
                EntityUtils.consume(response.getEntity());
                return responseBody;
            }
        }
    }
}
