package tk.springlearning.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import tk.springlearning.springcloud.component.MySource;
import tk.springlearning.springcloud.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(MySource.class)
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel myOutput;//消息发送通道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        myOutput.send(MessageBuilder.withPayload(serial).build());
        return serial;
    }
}
