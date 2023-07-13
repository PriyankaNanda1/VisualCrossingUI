package POM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndTest {

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
		// Enter City Name in TextBox
		driver.findElement(By.id("wxlocation")).sendKeys("Raichur");
		// Click on Dropdown
		driver.findElement(By.xpath("//span[@class='dropdown-toggle-label']")).click();
		// Select History Option
		driver.findElement(By.xpath("//span[@class='dropdown-item-label'][normalize-space()='History']")).click();
		// Click on Search Button
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		// Assert that the Title contains Historical since we selected history in
		// Dropdown
		Assert.assertTrue(driver.getTitle().contains("Historical"));
		System.out.println(driver.getTitle());
		// Assert that the URL contains history since we selected history in DropDown
		Assert.assertTrue(driver.getCurrentUrl().contains("weather-history"));
		System.out.println(driver.getCurrentUrl());
		// Select celcius Button
		driver.findElement(By.xpath("//button[normalize-space()='C']")).click();
		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(3000);
		// First Tooltip Graph
		List<WebElement> element = driver
				.findElements(By.xpath("//body/main[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div"));

		for (int i = 1; i < element.size() + 1; i++) {
			int ivalue = i;
			WebElement ele1 = driver.findElement(
					By.xpath("//body/main[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[" + ivalue + "]/div"));
			WebElement ele2 = driver.findElement(By
					.xpath("//body/main[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[" + ivalue + "]/div[2]"));
			System.out.println("Tooltip: ");
			System.out.println(ele1.getText() + " " + ele2.getText());

		}
		// Temperature Graph If all the svg elements are clickable
		String Temperaturegraphsvg = "//*[local-name()='svg']//*[name()='g' and @class='main']/*[name()='rect' and @class='normalbar' or @class='maxbar']";
		List<WebElement> temperaturegraph = driver.findElements(By.xpath(Temperaturegraphsvg));
		Actions act = new Actions(driver);
		for (WebElement e : temperaturegraph) {
			act.moveToElement(e).build().perform();
		}
		// Prints Temperature Graph Tooltip Value
		WebElement tooltipElement = null;
		try {
			tooltipElement = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='tooltip' and @data-v-6a9bc2bd]")));
		} catch (TimeoutException e) {
			System.out.println("Tooltip element not found within the given timeout period.");
		}

		if (tooltipElement != null) {
			List<WebElement> innerTextElements = tooltipElement.findElements(
					By.xpath(".//div[@class='contents']//div[contains(@class, 'title') or contains(@class, 'value')]"));

			for (WebElement element1 : innerTextElements) {
				String innerText = element1.getText().trim();
				if (!innerText.isEmpty()) {
					System.out.println("Temperature Graph Tooltip Value: ");
					System.out.println(innerText);
				}
			}
		}
		// Prints Precipitation If all the svg elements are clickable
		String Precipitationgraphsvg = "//*[local-name()='svg']//*[name()='g' and @class='main']/*[name()='rect' and @class='precipbar']";
		List<WebElement> precipitationgraph = driver.findElements(By.xpath(Precipitationgraphsvg));

		for (WebElement e : precipitationgraph) {

			act.moveToElement(e).build().perform();

		}

		// Prints Precipitation Graph Tooltip Value
		WebElement tooltipElement1 = null;
		try {
			tooltipElement1 = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//div[@class='tooltip' and @data-v-6a9bc2bd])[2]")));
		} catch (TimeoutException e) {
			System.out.println("Tooltip element not found within the given timeout period.");
		}

		if (tooltipElement1 != null) {
			List<WebElement> innerTextElements1 = tooltipElement1.findElements(
					By.xpath(".//div[@class='contents']//div[contains(@class, 'title') or contains(@class, 'value')]"));

			for (WebElement element1 : innerTextElements1) {
				String innerText1 = element1.getText().trim();
				if (!innerText1.isEmpty()) {
					System.out.println("Precipitation Graph Tooltip Value:");
					System.out.println(innerText1);
				}
			}
		}
		// Prints Degree If all the svg elements are clickable
		String Degreegraphsvg = "//*[local-name()='svg']//*[name()='g' and @class='main']/*[name()='rect' and @class='degreedaysbar' or @class='accdegreedaysbar']";
		List<WebElement> Degreegraph = driver.findElements(By.xpath(Degreegraphsvg));

		for (WebElement e : Degreegraph) {

			act.moveToElement(e).build().perform();

		}
		// Prints Degree Graph Tooltip Value
		WebElement tooltipElement2 = null;
		try {
			tooltipElement2 = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//div[@class='tooltip' and @data-v-6a9bc2bd])[4]")));
		} catch (TimeoutException e) {
			System.out.println("Tooltip element not found within the given timeout period.");
		}

		if (tooltipElement2 != null) {
			List<WebElement> innerTextElements2 = tooltipElement2.findElements(
					By.xpath(".//div[@class='contents']//div[contains(@class, 'title') or contains(@class, 'value')]"));

			for (WebElement element2 : innerTextElements2) {
				String innerText2 = element2.getText().trim();
				if (!innerText2.isEmpty()) {

					System.out.println(innerText2);
				}
			}
		}

		// Prints Windgraph If all the svg elements are clickable
		String Windgraphsvg = "//*[local-name()='svg']//*[name()='g' and @class='main']/*[name()='rect' and @class='windgustbar' or @class='windspeedbar']";
		List<WebElement> windgraph = driver.findElements(By.xpath(Windgraphsvg));

		for (WebElement e : windgraph) {

			act.moveToElement(e).build().perform();

		}
		// Prints Degree Graph Tooltip Value
		WebElement tooltipElement3 = null;
		try {
			tooltipElement3 = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//div[@class='tooltip' and @data-v-6a9bc2bd])[3]")));
		} catch (TimeoutException e) {
			System.out.println("Tooltip element not found within the given timeout period.");
		}

		if (tooltipElement3 != null) {
			List<WebElement> innerTextElements3 = tooltipElement3.findElements(
					By.xpath(".//div[@class='contents']//div[contains(@class, 'title') or contains(@class, 'value')]"));

			for (WebElement element3 : innerTextElements3) {
				String innerText3 = element3.getText().trim();
				if (!innerText3.isEmpty()) {
					System.out.println(innerText3);
				}
			}
		}

		// Find the table element
		WebElement tableElement = driver.findElement(By.xpath("//table[@class='table table-striped fs-xs']"));

		// Extract the data from the table
		String station = tableElement.findElement(By.xpath(".//tbody/tr/td[1]")).getText();
		String id = tableElement.findElement(By.xpath(".//tbody/tr/td[2]")).getText();
		String distance = tableElement.findElement(By.xpath(".//tbody/tr/td[3]")).getText();
		String latitude = tableElement.findElement(By.xpath(".//tbody/tr/td[4]")).getText();
		String longitude = tableElement.findElement(By.xpath(".//tbody/tr/td[5]")).getText();

		// Print the extracted data
		System.out.println("Table Elements:");
		System.out.println("Station\tId\tDistance (mi)\tLatitude\tLongitude");
		System.out.println(station + "\t" + id + "\t" + distance + "\t\t" + latitude + "\t\t" + longitude);

//		// Clicking on dropdown
//		// Move the mouse cursor away from the interfering element
//		WebElement interferingElement = driver
//				.findElement(By.xpath("//a[@class='nav-link text-nowrap' and contains(@href, '/weather-data')]"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(interferingElement, -10, -10).perform();
//
//		// Click the dropdown button
//		WebElement dropdownButton = driver.findElement(By.xpath("//button[@id='dateSelectionTypeDropdownButton']"));
//		dropdownButton.click();
//
//		// Selecting all Values From Dropdown and clicking on new Tab
//		List<WebElement> dropdownele = driver.findElements(By.xpath("//ul[@class='dropdown-menu show']/li"));
//		for (WebElement option : dropdownele) {
//			String optionText = option.getText();
//			System.out.println(optionText);
//
//			// Open the dropdown option in a new tab
//			// Actions actions = new Actions(driver);
//			actions.keyDown(Keys.CONTROL).click(option).keyUp(Keys.CONTROL).build().perform();
//
//			// Verify the date range on the new tab
//			WebElement dateRangeElement = driver.findElement(By.xpath("//your-date-range-element-xpath"));
//			String dateRangeText = dateRangeElement.getText();
//
//			boolean isDateRangeCorrect = verifyDateRange(dateRangeText, optionText);
//
//			System.out.println(
//					"Option: " + optionText + ", Date Range: " + dateRangeText + ", Correct: " + isDateRangeCorrect);
		}

	

	private static boolean verifyDateRange(String dateRangeText, String optionText) {
		// TODO Auto-generated method stub
		return true;
	}
}
