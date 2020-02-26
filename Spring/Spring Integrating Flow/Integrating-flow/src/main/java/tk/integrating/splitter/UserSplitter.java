package tk.integrating.splitter;

import java.util.ArrayList;
import java.util.Collection;

public class UserSplitter {

	public Collection<Object> splitUserIntoParts(User user) {
		ArrayList<Object> parts = new ArrayList<>();
		parts.add(user.getUserName());
		parts.add(user.getRole());
		parts.add(user.getBillingInfo());
		parts.add(user.getLineItems());
		return parts;
	}
}
