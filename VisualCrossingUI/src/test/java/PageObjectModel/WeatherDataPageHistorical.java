package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherDataPageHistorical {
	WebDriver driver;

	public WeatherDataPageHistorical(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space()='C']")
	WebElement celciusbutton;
	@FindBy(xpath = "//body/main[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div")
	List<WebElement> tooltipElements;

	public void getTooltips() {
		for (int i = 1; i <= tooltipElements.size(); i++) {
			WebElement element1 = tooltipElements.get(i).findElement(By.xpath("./div"));
			WebElement element2 = tooltipElements.get(i).findElement(By.xpath("./div[2]"));

			System.out.println(element1.getText() + " " + element2.getText());
		}
	}
	

	@FindBy(xpath = "//*[local-name()='svg']//*[name()='g' and @class='main']/*[name()='rect' and @class='normalbar' or @class='maxbar']")
	private List<WebElement> temperaturegraph;
	
	@FindBy(xpath = "(//div[@class='tooltip' and @data-v-6a9bc2bd])[]")
	private WebElement temperaturegraphtooltip;

	@FindBy(xpath = "(//div[@class='tooltip' and @data-v-6a9bc2bd])[2]")
	private WebElement precipitationgraph;

	@FindBy(xpath = "(//div[@class='tooltip' and @data-v-6a9bc2bd])[4]")
	private WebElement degreegraph;

	@FindBy(xpath = "(//div[@class='tooltip' and @data-v-6a9bc2bd])[3]")
	private WebElement windgraph;

	@FindBy(xpath = "//table[@class='table table-striped fs-xs']")
	private WebElement tableElement;

	@FindBy(xpath = "//div[@class='widget twocols']//div[@class='stationsMap']//div[@class='leaflet-container']//div[@class='leaflet-pane leaflet-map-pane']//table//tbody//td[text()='RAICHUR, IN']")
	private WebElement divElement;

	public void printTemperatureData() {
		for (WebElement element : temperaturegraph) {
			System.out.println(element.getText());
		}
	}

	public void printPrecipitationData() {
		System.out.println(precipitationgraph.getText());
	}

	public void printDegreeData() {
		System.out.println(degreegraph.getText());
	}

	public void printWindData() {
		System.out.println(windgraph.getText());
	}

	public void printTableData() {
		String station = tableElement.findElement(By.xpath(".//tbody/tr/td[1]")).getText();
		String id = tableElement.findElement(By.xpath(".//tbody/tr/td[2]")).getText();
		String distance = tableElement.findElement(By.xpath(".//tbody/tr/td[3]")).getText();
		String latitude = tableElement.findElement(By.xpath(".//tbody/tr/td[4]")).getText();
		String longitude = tableElement.findElement(By.xpath(".//tbody/tr/td[5]")).getText();

		System.out.println("Station\tId\tDistance (mi)\tLatitude\tLongitude");
		System.out.println(station + "\t" + id + "\t" + distance + "\t\t" + latitude + "\t\t" + longitude);
	}

	public String getRaichurLoc() {
		return divElement.getText();
	}

}
