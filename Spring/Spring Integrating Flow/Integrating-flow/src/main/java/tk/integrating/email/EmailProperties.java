package tk.integrating.email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="tk.integrating.email")
@Component
public class EmailProperties {
	private String username;
	private String password;
	private String host;
	private String port;
	private String mailbox;
	private long pollRate = 30000;
	
	public String getImapUrl() {
		String imapUrl = String.format("imaps://%s:%s@%s:%s/%s",this.username, this.password, this.host, this.port, this.mailbox);
		System.out.println(imapUrl);
		return imapUrl;
	}
}
