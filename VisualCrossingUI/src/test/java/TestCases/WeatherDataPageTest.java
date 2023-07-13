package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.BaseTest;
import PageObjectModel.HomePage;
import PageObjectModel.WeatherDataPage;

public class WeatherDataPageTest extends BaseTest {

    private WeatherDataPage weatherDataPage;

    @BeforeClass
    public void initializeWeatherDataPage() throws IOException {
        driver = initializeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.applicationurl();
        homePage.AcceptCookies();
        homePage.clickWeatherDatalink();
        weatherDataPage = new WeatherDataPage(driver);
    }

    @Test(priority=2)
    public void testWeatherDataPage() throws InterruptedException {
        String cityName = "Raichur";
        weatherDataPage.selectTextBox(cityName);
        weatherDataPage.selectDropdown();
        weatherDataPage.selectDropdownHistory();
        weatherDataPage.selectSearchButton();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getTitle().contains("Historical"));
		System.out.println(driver.getTitle());
		// Assert that the URL contains history since we selected history in DropDown
		Assert.assertTrue(driver.getCurrentUrl().contains("weather-history"));
        
    }
}
