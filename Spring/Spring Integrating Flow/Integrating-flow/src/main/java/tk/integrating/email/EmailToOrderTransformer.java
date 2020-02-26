package tk.integrating.email;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.springframework.integration.mail.transformer.AbstractMailMessageTransformer;
import org.springframework.integration.support.AbstractIntegrationMessageBuilder;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmailToOrderTransformer extends AbstractMailMessageTransformer<Order>{

	@Override
	protected AbstractIntegrationMessageBuilder<Order> doTransform(Message mailMessage) throws Exception {
		// TODO Auto-generated method stub
		Order order = processPayload(mailMessage);
		return MessageBuilder.withPayload(order);
	}
	
	private Order processPayload(Message mailMessage) throws MessagingException, IOException {
		String subject = mailMessage.getSubject();
		Order order = null;
		if(subject.contains("spring integrating")) {
			order = new Order(subject);
			String content = mailMessage.getContent().toString();
			
			String[] lines = content.split("\\r?\\n");
		    for (String line : lines) {
		    	order.addText(line);
		    }
		}
		return order;
	}

}
