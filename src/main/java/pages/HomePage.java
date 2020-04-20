package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//section[@class='content-header']")
	WebElement homePageheaderText;
	
	@FindBy(xpath = "/html/body/div[1]/aside/section/ul/li")
	WebElement getSideBarText;

	@FindBy(xpath = "/html/body/div[1]/header/nav/div/ul/li[2]/a")
	WebElement inventoryMenu;
	
	@FindBy(xpath = "/html/body/div[1]/header/nav/div/ul/li[2]/ul/li[1]/a")
	WebElement inventoryMenuProductOption;
	
	@FindBy(xpath = "/html/body/div[1]/header/nav/div/ul/li[2]/ul/li[2]/a")
	WebElement inventoryMenuSupplierOption;
	
	@FindBy(xpath = "/html/body/div[1]/header/nav/div/ul/li[2]/ul/li[3]/a")
	WebElement inventoryMenuRoOption;
	
	@FindBy(xpath = "/html/body/div[1]/header/nav/div/ul/li[2]/ul/li[4]/a")
	WebElement inventoryMenuQoOption;
	
	@FindBy(xpath = "/html/body/div[1]/header/nav/div/ul/li[2]/ul/li[5]/a")
	WebElement inventoryMenuPoOption;
	
	@FindBy(xpath = "/html/body/div[1]/header/nav/div/ul/li[2]/ul/li[6]/a")
	WebElement inventoryMenuPurchaseOption;
	
	@FindBy(xpath = "/html/body/div[1]/header/nav/div/ul/li[8]/a")
	WebElement menuProfileOption;
	
	@FindBy(xpath = "/html/body/div[1]/header/nav/div/ul/li[8]/ul/li[5]/a")
	WebElement userLogOutOPtion;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getHomePageHeaderText() {
		PageUtility.waitforanElement(driver, homePageheaderText, 30);
		return homePageheaderText.getText();
	}
	
	public String getHomePageSideBarText() {
		return getSideBarText.getText();
	}
	
		public void clickInventoryMenuModule() {
		PageUtility.waitforanElement(driver, homePageheaderText, 30);
		inventoryMenu.click();
	}
	
	public String getInventoryMenuProductOPtionText() {
		return inventoryMenuProductOption.getText();
	}
		
	public String getInventoryMenuSupplierOPtionText() {
		return inventoryMenuSupplierOption.getText();
	}
	
	public String getInventoryMenuRoOPtionText() {
		return inventoryMenuRoOption.getText();
	}
	
	public String getInventoryMenuQoOPtionText() {
		return inventoryMenuQoOption.getText();
	}
	
	public String getInventoryMenuPoOPtionText() {
		return inventoryMenuPoOption.getText();
	}
	
	public String getInventoryMenuPurchaseOPtionText() {
		return inventoryMenuPurchaseOption.getText();
	}
	
	public void ClickOnProfileIcon() {
		PageUtility.waitforanElement(driver, menuProfileOption, 30);
		menuProfileOption.click();
	}
	
	public void ClickOnLogout() {
		userLogOutOPtion.click();
	}
	
	public ProductPage clickProductOption() {
		inventoryMenuProductOption.click();
		return new ProductPage(driver);
	}
	
	public SupplierPage clickSupplierOption() {
		inventoryMenuSupplierOption.click();
		return new SupplierPage(driver);
	}
	
	public RosPage clickRosOption() {
		inventoryMenuRoOption.click();
		return new RosPage(driver);
	}
}
