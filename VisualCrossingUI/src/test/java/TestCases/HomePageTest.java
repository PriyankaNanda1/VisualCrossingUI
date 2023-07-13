package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.BaseTest;
import PageObjectModel.HomePage;

public class HomePageTest extends BaseTest {
	
	private HomePage homePage;
	
	
	
	@Test(priority=1)
    public void testHomePage() {
		
		HomePage homePage = new HomePage(driver);
        homePage.applicationurl();
        homePage.AcceptCookies();
        String expectedTitle = "Weather Data & Weather API | Visual Crossing"; 
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(driver.getTitle());
        homePage.clickWeatherDatalink();

}
}
