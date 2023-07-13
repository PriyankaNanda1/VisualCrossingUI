package AbstractClassPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractclass {
	WebDriver driver;

	public Abstractclass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

}
