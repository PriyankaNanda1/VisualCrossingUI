package api.pojo;

import java.util.List;

public class HoursPojo {

	@Override
	public String toString() {
		return "HoursPojo [datetime=" + datetime + ", datetimeEpoch=" + datetimeEpoch + ", temp=" + temp
				+ ", feelslike=" + feelslike + ", humidity=" + humidity + ", dew=" + dew + ", precip=" + precip
				+ ", precipprob=" + precipprob + ", snow=" + snow + ", snowdepth=" + snowdepth + ", preciptype="
				+ preciptype + ", windgust=" + windgust + ", windspeed=" + windspeed + ", winddir=" + winddir
				+ ", pressure=" + pressure + ", visibility=" + visibility + ", cloudcover=" + cloudcover
				+ ", solarradiation=" + solarradiation + ", solarenergy=" + solarenergy + ", uvindex=" + uvindex
				+ ", severerisk=" + severerisk + ", conditions=" + conditions + ", icon=" + icon + ", stations="
				+ stations + ", source=" + source + ", sunrise=" + sunrise + ", sunriseEpoch=" + sunriseEpoch
				+ ", sunset=" + sunset + ", sunsetEpoch=" + sunsetEpoch + ", moonphase=" + moonphase + ", getSunrise()="
				+ getSunrise() + ", getSunriseEpoch()=" + getSunriseEpoch() + ", getSunset()=" + getSunset()
				+ ", getSunsetEpoch()=" + getSunsetEpoch() + ", getMoonphase()=" + getMoonphase() + ", getDatetime()="
				+ getDatetime() + ", getDatetimeEpoch()=" + getDatetimeEpoch() + ", getTemp()=" + getTemp()
				+ ", getFeelslike()=" + getFeelslike() + ", getHumidity()=" + getHumidity() + ", getDew()=" + getDew()
				+ ", getPrecip()=" + getPrecip() + ", getPrecipprob()=" + getPrecipprob() + ", getSnow()=" + getSnow()
				+ ", getSnowdepth()=" + getSnowdepth() + ", getPreciptype()=" + getPreciptype() + ", getWindgust()="
				+ getWindgust() + ", getWindspeed()=" + getWindspeed() + ", getWinddir()=" + getWinddir()
				+ ", getPressure()=" + getPressure() + ", getVisibility()=" + getVisibility() + ", getCloudcover()="
				+ getCloudcover() + ", getSolarradiation()=" + getSolarradiation() + ", getSolarenergy()="
				+ getSolarenergy() + ", getUvindex()=" + getUvindex() + ", getSevererisk()=" + getSevererisk()
				+ ", getConditions()=" + getConditions() + ", getIcon()=" + getIcon() + ", getStations()="
				+ getStations() + ", getSource()=" + getSource() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	private String datetime;
	private long datetimeEpoch;
	private double temp;
	private double feelslike;
	private double humidity;
	private double dew;
	private double precip;
	private double precipprob;
	private double snow;
	private double snowdepth;
	private List<String> preciptype;
	private double windgust;
	private double windspeed;
	private double winddir;
	private double pressure;
	private double visibility;
	private double cloudcover;
	private double solarradiation;
	private double solarenergy;
	private double uvindex;
	private double severerisk;
	private String conditions;
	private String icon;
	private List<String> stations;
	private String source;
	private String sunrise;
	private long sunriseEpoch;
	private String sunset;
	private long sunsetEpoch;
	private double moonphase;

	public String getSunrise() {
		return sunrise;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public long getSunriseEpoch() {
		return sunriseEpoch;
	}

	public void setSunriseEpoch(long sunriseEpoch) {
		this.sunriseEpoch = sunriseEpoch;
	}

	public String getSunset() {
		return sunset;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	public long getSunsetEpoch() {
		return sunsetEpoch;
	}

	public void setSunsetEpoch(long sunsetEpoch) {
		this.sunsetEpoch = sunsetEpoch;
	}

	public double getMoonphase() {
		return moonphase;
	}

	public void setMoonphase(double moonphase) {
		this.moonphase = moonphase;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public long getDatetimeEpoch() {
		return datetimeEpoch;
	}

	public void setDatetimeEpoch(long datetimeEpoch) {
		this.datetimeEpoch = datetimeEpoch;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getFeelslike() {
		return feelslike;
	}

	public void setFeelslike(double feelslike) {
		this.feelslike = feelslike;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getDew() {
		return dew;
	}

	public void setDew(double dew) {
		this.dew = dew;
	}

	public double getPrecip() {
		return precip;
	}

	public void setPrecip(double precip) {
		this.precip = precip;
	}

	public double getPrecipprob() {
		return precipprob;
	}

	public void setPrecipprob(double precipprob) {
		this.precipprob = precipprob;
	}

	public double getSnow() {
		return snow;
	}

	public void setSnow(double snow) {
		this.snow = snow;
	}

	public double getSnowdepth() {
		return snowdepth;
	}

	public void setSnowdepth(double snowdepth) {
		this.snowdepth = snowdepth;
	}

	public List<String> getPreciptype() {
		return preciptype;
	}

	public void setPreciptype(List<String> preciptype) {
		this.preciptype = preciptype;
	}

	public double getWindgust() {
		return windgust;
	}

	public void setWindgust(double windgust) {
		this.windgust = windgust;
	}

	public double getWindspeed() {
		return windspeed;
	}

	public void setWindspeed(double windspeed) {
		this.windspeed = windspeed;
	}

	public double getWinddir() {
		return winddir;
	}

	public void setWinddir(double winddir) {
		this.winddir = winddir;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getVisibility() {
		return visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	public double getCloudcover() {
		return cloudcover;
	}

	public void setCloudcover(double cloudcover) {
		this.cloudcover = cloudcover;
	}

	public double getSolarradiation() {
		return solarradiation;
	}

	public void setSolarradiation(double solarradiation) {
		this.solarradiation = solarradiation;
	}

	public double getSolarenergy() {
		return solarenergy;
	}

	public void setSolarenergy(double solarenergy) {
		this.solarenergy = solarenergy;
	}

	public double getUvindex() {
		return uvindex;
	}

	public void setUvindex(double uvindex) {
		this.uvindex = uvindex;
	}

	public double getSevererisk() {
		return severerisk;
	}

	public void setSevererisk(double severerisk) {
		this.severerisk = severerisk;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<String> getStations() {
		return stations;
	}

	public void setStations(List<String> stations) {
		this.stations = stations;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
