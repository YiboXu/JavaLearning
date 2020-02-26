package tk.integrating.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;

@Configuration
public class RouterWriterIntegrationConfig {
	@Bean
	public IntegrationFlow routerWriterFlow() {
		 return IntegrationFlows
				 .from(MessageChannels.direct("inputChannel2"))
				 .<String, Integer>transform(Integer::parseInt)
				 .<Integer, String>route(n -> n%2==0 ? "EVEN":"ODD", mapping -> mapping
						 .subFlowMapping("EVEN", sf -> sf
								 .<Integer, Integer>transform(n -> n * 10)
								 .handle((m) -> System.out.println("EVEN n * 10: "+m.getPayload()))
						 )
						 .subFlowMapping("ODD", sf -> sf
								 .<Integer, Integer>transform(n -> n * 2)
								 .handle((m) -> System.out.println("EVEN n * 2: "+m.getPayload()))
						 )
				)
				.get();
				
	}
}
