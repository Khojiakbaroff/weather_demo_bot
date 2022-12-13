package demo_project.model;

import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("localtime")
	private String localtime;

	@SerializedName("country")
	private String country;

	@SerializedName("localtime_epoch")
	private int localtimeEpoch;

	@SerializedName("name")
	private String name;

	@SerializedName("lon")
	private double lon;

	@SerializedName("region")
	private String region;

	@SerializedName("lat")
	private double lat;

	@SerializedName("tz_id")
	private String tzId;

	public String getLocaltime() {
		return localtime;
	}

	public String getCountry() {
		return country;
	}

	public int getLocaltimeEpoch() {
		return localtimeEpoch;
	}

	public String getName() {
		return name;
	}

	public double getLon() {
		return lon;
	}

	public String getRegion() {
		return region;
	}

	public double getLat() {
		return lat;
	}

	public String getTzId() {
		return tzId;
	}

	@Override
	public String toString() {
		return "Location{" +
				"localtime='" + localtime + '\'' +
				", country='" + country + '\'' +
				", localtimeEpoch=" + localtimeEpoch +
				", name='" + name + '\'' +
				", lon=" + lon +
				", region='" + region + '\'' +
				", lat=" + lat +
				", tzId='" + tzId + '\'' +
				'}';
	}
}