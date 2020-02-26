package tk.integrating.splitter;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel="inputChannel3")
public interface SplitterWriterGateway {
	void writeToChannel(@Header("MsgHeader") String header, User data);
}
