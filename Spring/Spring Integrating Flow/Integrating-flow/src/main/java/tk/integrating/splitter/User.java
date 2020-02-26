package tk.integrating.splitter;

import java.util.Arrays;
import java.util.List;

public class User {
	private String username;
	private String role;
	private String password;
	private BillingInfo billingInfo;
	private List<LineItem> lineItems = Arrays.asList(new LineItem("lineitem1"),new LineItem("lineitem2"));
	
	public User(String username, String password, String role, BillingInfo billingInfo) {
		this.username = username;
		this.role = role;
		this.password = password;
		this.billingInfo = billingInfo;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public BillingInfo getBillingInfo() {
		return billingInfo;
	}
	
	public List<LineItem> getLineItems(){
		return lineItems;
	}
}
