package tk.springlearning.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import tk.springlearning.springcloud.component.MySink;

@Component
//消息接收端，MySink里面是绑定的input要跟我们配置文件的input关联的。
@EnableBinding(MySink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(MySink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者，-------" + message.getPayload() + "\t port:" + serverPort);
    }
}
