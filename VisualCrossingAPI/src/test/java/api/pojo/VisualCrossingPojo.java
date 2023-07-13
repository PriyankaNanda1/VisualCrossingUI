package api.pojo;

import java.util.List;

public class VisualCrossingPojo {

	private int queryCost;
	private double latitude;
	private double longitude;
	private String resolvedAddress;
	private String address;
	private String timezone;
	private double tzoffset;
	private String description;
	private List<DaysPojo> days;
	private List<String> alerts;
	private CurrentConditionsPojo currentConditions;

	public int getQueryCost() {
		return queryCost;
	}

	public void setQueryCost(int queryCost) {
		this.queryCost = queryCost;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getResolvedAddress() {
		return resolvedAddress;
	}

	public void setResolvedAddress(String resolvedAddress) {
		this.resolvedAddress = resolvedAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public double getTzoffset() {
		return tzoffset;
	}

	public void setTzoffset(double tzoffset) {
		this.tzoffset = tzoffset;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DaysPojo> getDays() {
		return days;
	}

	public void setDays(List<DaysPojo> days) {
		this.days = days;
	}

	public List<String> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<String> alerts) {
		this.alerts = alerts;
	}

	public CurrentConditionsPojo getCurrentConditions() {
		return currentConditions;
	}

	public void setCurrentConditions(CurrentConditionsPojo currentConditions) {
		this.currentConditions = currentConditions;
	}

	public void deserialize(String response) {
		// TODO Auto-generated method stub
		
	}

}
