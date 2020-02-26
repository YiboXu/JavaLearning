package tk.integrating.router;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel="inputChannel2")
public interface RouterWriterGateway {
	void writeToChannel(@Header("MsgHeader") String header, String data);
}
