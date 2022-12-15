package demo_project.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.asif.gsonpojogenerator")
public class Weather{

	@SerializedName("current")
	private Current current;

	@SerializedName("location")
	private Location location;

	public Current getCurrent(){
		return current;
	}

	public Location getLocation(){
		return location;
	}

	@Override
 	public String toString(){
		return 
			"Weather" +
			"current = '" + current + '\'' + 
			",location = '" + location + '\'' + 
			"";
		}
}