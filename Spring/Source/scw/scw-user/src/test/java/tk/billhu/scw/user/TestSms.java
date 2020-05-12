package tk.billhu.scw.user;

import org.apache.http.HttpResponse;
import tk.billhu.scw.user.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class TestSms {
    public static void main(String[] args) {
        String host = "https://api.netease.im";
        String path = "/sms/sendcode.action";
        String method = "POST";
        String appkey = "42c2ebd07c7c4a95b270feff6c896c6c";
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Authorization","AppKey "+appkey);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile","18062629796");
        querys.put("param","code:1234");
        querys.put("tpl_id","TP1711063");
        Map<String, String> bodys = new HashMap<String, String>();

        try{
            HttpResponse response = HttpUtils.doPost(host,path,method,headers,querys,bodys);
            System.out.println(response.toString());
        }catch (Exception e){

        }
    }
}














