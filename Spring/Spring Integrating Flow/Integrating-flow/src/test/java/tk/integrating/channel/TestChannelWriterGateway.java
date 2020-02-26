package tk.integrating.channel;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tk.integrating.channel.ChannelWriterGateway;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestChannelWriterGateway {

	@Autowired
	private ChannelWriterGateway channelWriterGateway;
	
	@Test
	public void testDemo() {
		channelWriterGateway.writeToChannel("TestMsgHeader", "Hello Message From Channel1");
	}
}
