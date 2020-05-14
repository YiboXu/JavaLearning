package tk.billhu.scw.user.component;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tk.billhu.scw.user.utils.HttpUtils;
import tk.billhu.scw.vo.resp.AppResponse;

import java.util.HashMap;
import java.util.Map;

@Component
public class SmsTemplate {
    //Get configuration value from application.properties
    @Value("${sms.host}")
    private String host;
    @Value("${sms.path}")
    private String path;
    @Value("${sms.method}")
    private String method;
    @Value("${sms.appcode}")
    private String appcode;

    public AppResponse<String> sendSms(Map<String, String> queries){

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization","APPCODE "+appcode);
        Map<String, String> bodies = new HashMap<String, String>();

        try{
            HttpResponse response = HttpUtils.doPost(host,path,method,headers,queries,bodies);

            return AppResponse.ok(response.toString());
        }catch (Exception e){
            return AppResponse.fail(null);
        }
    }
}
