package demo_project.model;

import com.google.gson.annotations.SerializedName;

public class Condition{

	@SerializedName("code")
	private int code;

	@SerializedName("icon")
	private String icon;

	@SerializedName("text")
	private String text;

	public int getCode() {
		return code;
	}

	public String getIcon() {
		return icon;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Condition{" +
				"code=" + code +
				", icon='" + icon + '\'' +
				", text='" + text + '\'' +
				'}';
	}
}