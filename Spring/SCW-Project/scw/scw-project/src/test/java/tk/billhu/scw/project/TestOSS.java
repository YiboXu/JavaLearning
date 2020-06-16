package tk.billhu.scw.project;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TestOSS {
    public static void main(String[] args) throws FileNotFoundException {
        String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
        String accessKeyId = "xxxxxx";
        String accessKeySecret = "yyyyy";
        String bucketName = "billhuscw20200428";
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = "scw-project/p1.jpg";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        InputStream is = new FileInputStream("C:\\Users\\TaoHu\\Desktop\\众筹网\\前端页面\\img\\p1.jpg");
        ossClient.putObject(bucketName, objectName, is);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
