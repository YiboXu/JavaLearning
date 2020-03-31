package tk.springlearning.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import tk.springlearning.springcloud.component.MySink2;

@Component
//消息接收端，MySink2里面是绑定的myInput2要跟我们配置文件的myInput2关联的。
@EnableBinding(MySink2.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(MySink2.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者，-------" + message.getPayload() + "\t port:" + serverPort);
    }
}
