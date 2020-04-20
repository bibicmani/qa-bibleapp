package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RosPage {
	public WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[1]/h1")
	WebElement getRosPageHeaderText;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[2]/p/a")
	WebElement getRosPageCreateRosButtonText;
	
	public RosPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getRosPageDisplayText() {
		return getRosPageHeaderText.getText();
	}
	
	public String getRosPageCreateRoButtonText() {
		return getRosPageCreateRosButtonText.getText();
	}

}
