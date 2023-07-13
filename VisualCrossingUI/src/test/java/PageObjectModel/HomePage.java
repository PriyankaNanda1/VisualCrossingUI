package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import AbstractClassPackage.Abstractclass;
import BasePackage.BaseTest;



public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	@FindBy(xpath = "//button[contains(text(), 'Accept all cookies')]")
	WebElement acceptcookies;
	@FindBy(xpath = "//a[@class='nav-link text-nowrap'][normalize-space()='Weather Data']")
	WebElement weatherdatalink;
    
	public void applicationurl() {
		driver.get("https://www.visualcrossing.com/");
	}

	public void AcceptCookies() {
		acceptcookies.click();
	}

	public void clickWeatherDatalink() {
		weatherdatalink.click();
	}

}
