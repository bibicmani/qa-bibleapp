package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateSupplier {
	public WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[1]/h1")
	WebElement updateSupplierHeaderText;
		
	public UpdateSupplier(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getUpdateSupplierPageHeaderText() {
		return updateSupplierHeaderText.getText();
	}
	
}
