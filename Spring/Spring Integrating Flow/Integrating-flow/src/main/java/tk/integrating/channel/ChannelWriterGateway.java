package tk.integrating.channel;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel="inputChannel1")
public interface ChannelWriterGateway {
	void writeToChannel(@Header("MsgHeader") String header, String data);
}
