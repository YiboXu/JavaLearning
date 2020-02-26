package tk.integrating.channel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageHandler;

@Configuration
public class ChannelWriterIntegrationConfig {

	@Bean
	@Transformer(inputChannel="inputChannel1", outputChannel="outputChannel1")
	public GenericTransformer<String, String> transformer1() {
		return text -> text.toUpperCase();
	}
	
	@Bean
	@ServiceActivator(inputChannel="outputChannel1")
	public MessageHandler sysoutHandler() {
		return message -> {
			System.out.println("Message payload: " + message.getPayload());
		};
	}
	
	@Bean
	public IntegrationFlow channelWriterFlow() {
		 return IntegrationFlows
				 .from(MessageChannels.direct("inputChannel1"))
				 .channel(MessageChannels.direct("outputChannel1"))
				 .handle(m->System.out.println("Message payload received through DSL: "+m))
				 .get();
				
	}
}
