package TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.BaseTest;
import PageObjectModel.HomePage;
import PageObjectModel.WeatherDataPage;
import PageObjectModel.WeatherDataPageHistorical;

public class WeatherDataPageHistoricalTest extends BaseTest {
	WeatherDataPageHistorical weatherDataPageHistorical = new WeatherDataPageHistorical(driver);

	@BeforeClass
	public void initializeWeatherDataPage() throws IOException {
		driver = initializeDriver();
		HomePage homePage = new HomePage(driver);
		homePage.applicationurl();
		homePage.AcceptCookies();
		homePage.clickWeatherDatalink();
		WeatherDataPage weatherDataPage = new WeatherDataPage(driver);
		String cityName = "Raichur";
		weatherDataPage.selectTextBox(cityName);
		weatherDataPage.selectDropdown();
		weatherDataPage.selectDropdownHistory();
		weatherDataPage.selectSearchButton();
	}

	//@Test(priority = 3)

	public void testWeatherDataPageHistorical() {

		WeatherDataPageHistorical weatherDataPageHistorical = new WeatherDataPageHistorical(driver);
        
		weatherDataPageHistorical.getTooltips();
		weatherDataPageHistorical.getRaichurLoc();
		System.out.println("Temperature data:");
		weatherDataPageHistorical.printTemperatureData();

		System.out.println("Precipitation data:");
		weatherDataPageHistorical.printPrecipitationData();

		System.out.println("Degree data:");
		weatherDataPageHistorical.printDegreeData();

		System.out.println("Wind data:");
		weatherDataPageHistorical.printWindData();

		System.out.println("Table data:");
		weatherDataPageHistorical.printTableData();

	}
}
