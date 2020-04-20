package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[1]/h1")
	WebElement getProductPageText;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[2]/div[1]/table/thead/tr")
	WebElement productPageTableHeadings;
	
	@FindBy(xpath = "/html/body/div[1]/div/section[2]/p/a")
	WebElement createProductText;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProductPageDisplayText() {
		return getProductPageText.getText();
	}
	
	public String getProductPageCreateProductButtonText() {
		return createProductText.getText();
	}
	
	public CreateProductPage clickCreateProduct() {
		createProductText.click();
		return new CreateProductPage(driver);
	}
	
}
