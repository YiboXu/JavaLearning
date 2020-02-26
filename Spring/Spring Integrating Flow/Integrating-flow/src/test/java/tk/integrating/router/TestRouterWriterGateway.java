package tk.integrating.router;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRouterWriterGateway {
	@Autowired
	private RouterWriterGateway routerWriterGateway;
	
	@Test
	public void testDemo() {
		routerWriterGateway.writeToChannel("TestMsgHeader", "1");
		routerWriterGateway.writeToChannel("TestMsgHeader", "2");
		routerWriterGateway.writeToChannel("TestMsgHeader", "3");
		routerWriterGateway.writeToChannel("TestMsgHeader", "4");
		routerWriterGateway.writeToChannel("TestMsgHeader", "5");
		routerWriterGateway.writeToChannel("TestMsgHeader", "6");
	}
}
