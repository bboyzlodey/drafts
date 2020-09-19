package skarlat.dev.requiresofvacancy;

import java.io.Serializable;
import java.util.List;

public class Vacancy extends AbstractItem implements Serializable {
	List<Require> requires;
	
	public Vacancy(String name) {
		super(name);
	}
	
}
