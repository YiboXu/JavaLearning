package tk.springlearning.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import tk.springlearning.springcloud.component.MyProcessor;

@Component
//消息中转，MyProcessor里面是绑定的myInput1要跟我们配置文件的myInput1关联.
//同时， MyProcessor里面是绑定的myOutput1要跟我们配置文件的myOutput1关联。
@EnableBinding(MyProcessor.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    //从inputChannel接收消息，进行处理，然后转发到outputChannel
    @ServiceActivator(inputChannel = MyProcessor.INPUT,outputChannel = MyProcessor.OUTPUT)
    public Message<String> input(Message<String> message) {
        System.out.println("消息已处理" + message.getPayload() + "\t port:" + serverPort);
        return MessageBuilder.withPayload("<--"+message.getPayload().toUpperCase()+"-->").build();
    }
}
