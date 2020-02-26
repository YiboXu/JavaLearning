package tk.integrating.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.dsl.Files;

@Configuration
public class AdapterWriterIntegrationConfig {
	
	@Bean
	public AtomicInteger getInteger() {
		return new AtomicInteger(0);
	}
	
	//@Bean
	public IntegrationFlow adapterFlow1(AtomicInteger integerSource) {
		return IntegrationFlows
				.from(integerSource, "getAndIncrement", c -> c.poller(Pollers.fixedRate(1000)))
				.handle(m -> System.out.println(m))
				.get();
				
				
	}
	
	@Bean
	public IntegrationFlow fileReaderFlow1() {
		
		return IntegrationFlows
				.from(Files.inboundAdapter(new File("C:\\testFiles"))
				.patternFilter("*"),c -> c.poller(Pollers.fixedRate(1000)))
				.handle(m -> {
					try (BufferedReader br = new BufferedReader(new FileReader(m.getPayload().toString()));){
						String rec = br.readLine();
						while(rec != null) {
							System.out.println(rec);
							rec = br.readLine();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				})
				.get();
	}

}
