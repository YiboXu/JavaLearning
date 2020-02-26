package tk.integrating.splitter;

import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;

@Configuration
public class SplitterWriterIntegrationConfig {
	
	@Bean
	public IntegrationFlow splitterWriterFlow() {
		 return IntegrationFlows
				 .from(MessageChannels.direct("inputChannel3"))
				 .split(new UserSplitter())
				 .<Object, String> route(
						 p -> {
							 if (p.getClass().isAssignableFrom(BillingInfo.class)) {
								 return "BILLING_INFO";
							 } else if (p.getClass().getCanonicalName().equals("java.util.Arrays.ArrayList")) {
								 return "LINE_ITEMS";
							 } else {
								 return "OTHERS";
							 }
						 }, mapping -> mapping
						 .subFlowMapping("BILLING_INFO", sf -> sf
								 .<BillingInfo> handle((billingInfo) -> {
									 System.out.println("BillingInfo: "+billingInfo);
								 }))
						 .subFlowMapping("LINE_ITEMS", sf -> sf
									.split()
									.<LineItem> handle((lineItem) -> {
										 System.out.println("Line_Items: "+lineItem);
									 }))
						 .subFlowMapping("OTHERS", sf -> sf
								 .<String> handle((lineItem) -> {
									 System.out.println("Others: "+lineItem);
								 }))
						 )
				.get();
				 
	}
}
