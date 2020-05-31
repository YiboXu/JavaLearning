package tk.billhu.gulimall.thirdparty;

import com.aliyun.oss.OSS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OssTest {
    @Autowired
    private OSS ossClient;

    @Test
    public void test01() throws FileNotFoundException {
        ossClient.putObject("billhuscw20200428", "gulimall-project/23cd65077f12f7f5.jpg", new FileInputStream("c:/23cd65077f12f7f5.jpg"));
    }
}
