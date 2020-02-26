package tk.integrating.email;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Order {
	private final String email;
	private List<String> contents = new ArrayList<>();
	
	public void addText(String text) {
		this.contents.add(text);
	}
}
