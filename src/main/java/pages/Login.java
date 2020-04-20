package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]")
	WebElement actualText;
	
	@FindBy(xpath = "//input[@name = 'LoginForm[username]']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@name = 'LoginForm[password]']")
	WebElement passWord;

	@FindBy(xpath = "//button[@name = 'login-button']")
	WebElement submit;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[3]/form/div[1]/p")
	WebElement loginErrorMsg;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getTextDisplay() {
		return actualText.getText();
	}
	public String getExpectedText() {
		String expectedText = "Welcome to\n" + "SS LEGACY Engineers";
		return expectedText;
	}
	
	public String getErrorMessage() {
		return loginErrorMsg.getText();
	}
	
	public HomePage loginFunction(String uName, String pWord) {
		userName.sendKeys(uName);
		passWord.sendKeys(pWord);
		submit.click();
		return new HomePage(driver);
	}

}
