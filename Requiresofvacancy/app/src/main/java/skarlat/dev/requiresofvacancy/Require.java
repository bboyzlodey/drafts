package skarlat.dev.requiresofvacancy;

import java.io.Serializable;
import java.util.List;

public class Require extends AbstractItem implements Serializable {
	private int count;
	public Require(String name){
		super(name);
		count = 1;
	}
	public int getCount(){
		return count;
	}
	
	public int countIncrease(){
		return (count++);
	}
}
