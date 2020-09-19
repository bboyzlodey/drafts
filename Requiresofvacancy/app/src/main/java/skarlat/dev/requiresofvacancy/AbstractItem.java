package skarlat.dev.requiresofvacancy;

import java.io.Serializable;

public class AbstractItem implements Serializable {
	String name;
	
	public AbstractItem(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
