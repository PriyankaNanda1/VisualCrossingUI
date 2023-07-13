package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherDataPage {
	
	WebDriver driver;

	public WeatherDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	@FindBy(id = "wxlocation")
	WebElement textbox;
	@FindBy(xpath = "//span[@class='dropdown-toggle-label']")
	WebElement dropdown;
	@FindBy(xpath = "//span[@class='dropdown-item-label'][normalize-space()='History']")
	WebElement dropdownhistory;
	@FindBy(xpath = "//span[@class='dropdown-item-label'][normalize-space()='Forecast']")
	WebElement dropdownforecast;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchbutton;
	
	public void selectTextBox(String cityName)
	{
		textbox.clear();
		textbox.sendKeys(cityName);
	}
	
	public void selectDropdown()
	{
		dropdown.click();
	}
	
	public void selectDropdownHistory()
	{
		dropdownhistory.click();
	}
	public void selectDropdownForecast()
	{
		dropdownforecast.click();
	}
	public void selectSearchButton()
	{
		searchbutton.click();
	}



}
