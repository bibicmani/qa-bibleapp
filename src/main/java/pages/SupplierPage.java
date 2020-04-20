package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierPage {
	public WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[1]/h1")
	WebElement getSupplierPageText;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[2]/p/a")
	WebElement createSupplierText;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[2]/div[1]/table/tbody/tr[1]/td[5]/a[1]/span")
	WebElement viewSupplierButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[2]/div[1]/table/tbody/tr[1]/td[5]/a[2]/span")
	WebElement updateSupplierButton;
	
	public SupplierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getSupplierPageDisplayText() {
		return getSupplierPageText.getText();
	}
	
	public String getSupplierPageCreateSupplierText() {
		return viewSupplierButton.getText();
	}

	public ViewSupplier clickViewSupplierOption() {
		viewSupplierButton.click();
		return new ViewSupplier(driver);
	}
	
	public UpdateSupplier clickUpdateSupplierButton() {
		updateSupplierButton.click();
		return new UpdateSupplier(driver);
	}
	
	/*public CreateSupplierPage clickCreateSupplier() {
		createSupplierText.click();
		return new CreateSupplierPage(driver);
	}*/

}
