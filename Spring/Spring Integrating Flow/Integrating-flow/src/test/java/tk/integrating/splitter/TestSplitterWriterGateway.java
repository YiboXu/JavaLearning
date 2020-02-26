package tk.integrating.splitter;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSplitterWriterGateway {

	@Autowired
	private SplitterWriterGateway splitterWriterGateway;
	
	@Test
	public void testDemo() {
		splitterWriterGateway.writeToChannel("User1", new User("Billhu","123456","Admin",new BillingInfo("Credit-Card1")));
		splitterWriterGateway.writeToChannel("User2", new User("Hutao","123456","User",new BillingInfo("AMEX-Card1")));
	}
}
