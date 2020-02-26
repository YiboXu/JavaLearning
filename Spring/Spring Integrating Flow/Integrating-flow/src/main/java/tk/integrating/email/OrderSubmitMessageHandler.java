package tk.integrating.email;

import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class OrderSubmitMessageHandler implements GenericHandler<Order>{

	@Override
	public Object handle(Order payload, MessageHeaders headers) {
		// TODO Auto-generated method stub
		System.out.println(payload.getEmail()+":"+payload.getContents());
		return null;
	}

}
