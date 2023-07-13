package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WeatherDataForecast {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.visualcrossing.com/");
		// Accept All Cookies
		driver.findElement(By.xpath("//button[contains(text(), 'Accept all cookies')]")).click();
		// Click on Weather Data Link
		driver.findElement(By.xpath("//a[@class='nav-link text-nowrap'][normalize-space()='Weather Data']")).click();
		driver.findElement(By.id("wxlocation")).clear();
		String cityname = "Raichur";
		// Enter City Name in TextBox
		driver.findElement(By.id("wxlocation")).sendKeys(cityname);
		// Click on Dropdown
		driver.findElement(By.xpath("//span[@class='dropdown-toggle-label']")).click();
		// Select History Option
		driver.findElement(By.xpath("//span[@class='dropdown-item-label'][normalize-space()='Forecast']")).click();
		// Click on Search Button
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		// Assert that the Title contains Forecast since we selected history in
		Assert.assertTrue(driver.getTitle().contains("Forecast"));
		System.out.println(driver.getTitle());
		// Assert that the URL contains weather-forecast since we selected forecast in DropDown
		Assert.assertTrue(driver.getCurrentUrl().contains("weather-forecast"));
		System.out.println(driver.getCurrentUrl());
		WebElement cityele = driver.findElement(By.xpath("(//a[@id='locationDropdownMenuButton'])"));
		String citytext = cityele.getText();
		//Assert That the CityName is Equal to the Cityname we Entered in Search TextBox
		Assert.assertEquals(cityname, citytext);
		System.out.println(citytext);
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> currentlygraph = driver.findElements(By.xpath("//div[@class='current maingrid']/*"));

		System.out.println("--------- Currently Graph Details ----------");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		for (WebElement element : currentlygraph) {
			String text = (String) jsExecutor.executeScript("return arguments[0].textContent.trim();", element);
			System.out.println(text);
		}

		List<WebElement> threedaygraph = driver
				.findElements(By.xpath("//div[@class='widget threecols']//div[@class='maingrid']/*"));

		System.out.println("--------- 3 Day Outlook Graph Details ----------");

		JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;

		for (WebElement element : threedaygraph) {
			String text = (String) jsExecutor1.executeScript("return arguments[0].textContent.trim();", element);
			System.out.println(text);
		}

		List<WebElement> hourlyforecastgraph = driver.findElements(
				By.xpath("//div[@class='periods']//div[@class='time' or @class='temp' or @class='value']"));

		System.out.println("--------- Hourly forecast Graph Details ----------");

		JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;

		for (WebElement element : hourlyforecastgraph) {
			String text = (String) jsExecutor2.executeScript("return arguments[0].textContent.trim();", element);
			System.out.println(text);
		}
		List<WebElement> longtermoutlookgraph = driver.findElements(By.xpath(
				"//div[@class='period']//div[@class='dow' or @class='date' or @class='maxt' or @class='mint' or @class='value']"));

		System.out.println("--------- Long Term Outlook Hourly Graph Details ----------");

		JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;

		for (WebElement element : longtermoutlookgraph) {
			String text = (String) jsExecutor3.executeScript("return arguments[0].textContent.trim();", element);
			System.out.println(text);
		}
		
		driver.close();

	}

}
