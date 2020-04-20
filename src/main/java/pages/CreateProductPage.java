package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class CreateProductPage {
	public WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[1]/h1")
	WebElement getCreateProductPageText;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[1]/ul/li[3]")
	WebElement getBreadCrumbText;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[2]/div[1]/form/div[10]/button")
	WebElement productSaveButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[2]/div[1]/form/div[1]/div")
	WebElement nameFieldValidationMessage;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[2]/div[1]/form/div[1]/input")
	WebElement enterProductName;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[2]/div[1]/form/div[4]/select")
	WebElement unitDisplayField;
	
	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getCreateProductPageDisplayText() {
		return getCreateProductPageText.getText();
	}
	
	public String getCreateProductBreadCrumbText() {
		return getBreadCrumbText.getText();
	}
	
	public String getNameFieldValidationMessage() {
		PageUtility.waitforanElement(driver, nameFieldValidationMessage, 30);
		return nameFieldValidationMessage.getText();
	}

	public void enterNameofProduct() {
		enterProductName.sendKeys("Test");
	}
	
	public void enterUnitofProduct() {
		Select unitDisplayDropDown = new Select(unitDisplayField);
		unitDisplayDropDown.selectByValue("piece");
	}
	
	
	public void ClickOnSaveButton() {
		productSaveButton.click();
	}

}
