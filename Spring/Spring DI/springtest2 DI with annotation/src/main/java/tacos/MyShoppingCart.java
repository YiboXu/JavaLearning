package tacos;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.INTERFACES)
public class MyShoppingCart implements ShoppingCart{

	private static int count=1;
	private final int id=count++;
	
	public String toString() {
		return "ShoppingCart "+id;
	}
}
