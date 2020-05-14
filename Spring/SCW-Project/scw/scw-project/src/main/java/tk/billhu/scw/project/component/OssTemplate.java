package tk.billhu.scw.project.component;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.InputStream;

@Slf4j
@Data
public class OssTemplate {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String path;

    public String upload(InputStream source, String targetFileName){
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = path+"/"+targetFileName;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try{
            // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
            ossClient.putObject(bucketName, objectName, source);
            // 关闭OSSClient。
            ossClient.shutdown();

            String filePahtOnOss = "https://"+ bucketName+"."+endpoint+"/"+path+"/"+targetFileName;

            log.debug("文件上传成功-{}",filePahtOnOss);
            return filePahtOnOss;
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("文件上传失败-{}",targetFileName);
            return null;
        }
    }
}
