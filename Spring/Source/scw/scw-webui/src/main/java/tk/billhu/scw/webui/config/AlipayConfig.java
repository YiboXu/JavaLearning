package tk.billhu.scw.webui.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102200740240";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC76ftf5eKQj+GhilJm6hvuugXlSz7psygXLVr/ziMhUT0YPpH3xt+yrt4bOPdUx4Rx7UQBMX4t7rXUBZ+190aqPNsAEWwDIE9NxxL+aNYP9xu4dIgyaER+NGvmQOaymAZuwsSq63TqNdlYQKW1q87Y7OyavtTdqF77VQX6pXVRcFZighMXzKNjS9h1QMx/w1TIIvVthMk0zxrla7qT1Vyl5ibMPMA0vfZ8woWEYZ/HcCLsqn+q4MZUuIGVb6qWsoht60w7J9Cnq4jMN1p9Snc4+Do73LzFb5gNN19PI5mzC2kF73UdjcH8Ru6hch8ChdsF4tW/0qUTs3wCh2BF3DT5AgMBAAECggEAXu11ml1UVfkJX4Sz2d98Gt4IamvXrVFe+E5mQQGOh581gNDjBkuF6AskkpX1g/OCedcFWqD5ABUt75yjsNXo8cjqTR9/9BhXV5AwjSrCsLABZe4ge25m42Zx95BjumbIIR3tIfbuSf7H/Cg0ThEr3jPZ1tZ+TDdpPAgYjCUXnfqGU4qGwa9Is5sOtos7e9DK3q2TzHOL+lXVATXm5lq0MsV6xpTjzKvD9+cnIPfr4ZJ988pQoYFy8gncsRgGv2eUz6pggh4zLrlExzf0TJcZyKqaSMu1tYYn01f2MmdpwjZ5Sm9VDRYyn/BNjTMO8DWQRFCV3CXi45HHPqF0WAPznQKBgQDxtmsavsG84J24H0N3E1Mo7+xOKZwMp+6WhrskJMDYcxOyiMkwrarmFyoqtbh4I/8MZMqqUSq1Ixgs4bXqcZHl83oaxXzwdzA/nKxNrXsvOLpowO7pidYt3kGSyRL0xxhwo1ESNFtWjARyvJmSd3jeUECFkJaR5nVDaprKLacqjwKBgQDHBXyA2RulY1+F395HnOs4lYhb62Z0u1HlaZflmuNJeWYt7ZuUxg8fjhzN9XJVIfdAKQ5rIWMUFQCGef05wi4Ij5bPfChFfFtui5+3C91tyKRMKzL/BySc09WQz3r8845b12XbppZVZlrcWmAPYAP1qogDfOTn9sciW/3qQGIL9wKBgQCoYlMUq6TdhoB5HtZp4n2BPDqbbOM38dkE5dEC6dOqNeiX7DB0B9fROHv4iuV6VGE96g1BPxAIZe1Wftqy+vEPh2Edu0xBXFaxSdzCtELnb5Z0mUsWSB57j6SQtCDPgs8k0LEOhIjIrvv+TiKR5Ua/YJrCMSqjcy9niqFQjSMyQwKBgAgF7pj7J6QpN2acOcfFSa5ESPT7rmuySYDoGtmEvvjtTfM4CveabG2nOv4KkQthjSgm/4/ODsJ2fkjtjgnQDC8IKto+dRkoBD+WnV+xuMF+PzFa5HlnflBcMdXep2SfJPQK4O5T7ueOcsdDVXAJPN+gek85r7iyOCDoeHoDEnDNAoGAcOI9Zu9i4wVE66+bnX61L+sQcps7Bw2JlnUMJ5CuMCqKjOQKU9hyiLijCcQZSGhXtOS0XwuYFzlDipNnj4uuD3SqxeVXwn4cfDvIyo103S4YWfb40yzwZB+TgixSHqeLdAER8XQUlVpVaUc3oHCOSqrVObawXxWQJ5m7RKAkgn0=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAizW1T1DvpKolaxsChREi96GEYpPR/urnhjf5X+rKow4jipzA+9xogK26AgfJFC/ESEkC+KiuGlMLJ7W81pvIc/BlJ/pBwGZdchKfr0/ESgR52MqQbjq3b+dn4pnpIyIMCFssIi1hiCaSK5q2zbXuTT/YosvXFKQhR9dFSVAENL8oBzdLBAjQ0L9tAA8tFNHkD1hO0fYb8rypQsC06tSMtkQFyPEeulbxSZoeMob2jpuu1KUBeAOArIdaT8k3b9sAAACwgCUbE8z/BDrkym+JkTIh/X2jcjpfNuMPy3b2enzI/NtctzHXWpQ41hO78UlRYXI6HLBEu9ahTYafgOdx/QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://127.0.0.1:8201/order/updateStatus";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:10000/member/minecrowdfunding";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}