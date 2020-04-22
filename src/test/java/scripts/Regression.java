package scripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import pages.Login;
import pages.ProductPage;
import pages.RosPage;
import pages.SupplierPage;
import pages.UpdateSupplier;
import pages.ViewSupplier;
import utilities.ExcelUtility;
import utilities.GenericUtility;
import pages.CreateProductPage;
import pages.HomePage;

public class Regression extends TestHelper {
	@Test
	public void validateLoginFunction() throws IOException {
		String expectedHomePageHeader = "ERP | Dashboard";
		String expectedSideBarText = "MAIN NAVIGATION";
		GenericUtility getExcel = new GenericUtility();
		String getExcelData = getExcel.readData(1, 0);
		System.out.println("Value of a is: " + getExcelData);
		/*
		 * Login login = new Login(driver); HomePage homePage =
		 * login.loginFunction("bibin", "Bibin@123");
		 * assertEquals(homePage.getHomePageHeaderText(),
		 * expectedHomePageHeader, "Login Fails");
		 * assertEquals(homePage.getHomePageSideBarText(), expectedSideBarText,
		 * "Login Fails");
		 */

	}

	// @Test
	public void verifyInventoryDropDownOptionsDisplayed() {
		String expectedInventoryMenuProductOPtionText = "Product";
		String expectedInventoryMenuSupplierOPtionText = "Supplier";
		String expectedInventoryMenuRoOPtionText = "Ro";
		String expectedInventoryMenuPoOPtionText = "Po";
		String expectedInventoryMenuQoOPtionText = "Qo";
		String expectedInventoryMenuPurchaseOPtionText = "Purchase";
		Login login = new Login(driver);
		HomePage homePage = login.loginFunction("bibin", "Bibin@123");
		homePage.clickInventoryMenuModule();
		assertEquals(homePage.getInventoryMenuProductOPtionText(), expectedInventoryMenuProductOPtionText,
				"Wrong menu option for Product");
		assertEquals(homePage.getInventoryMenuSupplierOPtionText(), expectedInventoryMenuSupplierOPtionText,
				"Wrong menu option for Supplier");
		assertEquals(homePage.getInventoryMenuRoOPtionText(), expectedInventoryMenuRoOPtionText,
				"Wrong menu option for Ro");
		assertEquals(homePage.getInventoryMenuPoOPtionText(), expectedInventoryMenuPoOPtionText,
				"Wrong menu option for Po");
		assertEquals(homePage.getInventoryMenuQoOPtionText(), expectedInventoryMenuQoOPtionText,
				"Wrong menu option for Qo");
		assertEquals(homePage.getInventoryMenuPurchaseOPtionText(), expectedInventoryMenuPurchaseOPtionText,
				"Wrong menu option for Purchase");
	}

	// @Test
	public void verifyProductPageDisplay() {
		String expectedProductPageHeaderText = "Products";
		String expectedCreateProductButtonText = "Create Product";
		Login login = new Login(driver);
		HomePage homePage = login.loginFunction("bibin", "Bibin@123");
		homePage.clickInventoryMenuModule();
		ProductPage productPage = homePage.clickProductOption();
		assertEquals(productPage.getProductPageDisplayText(), expectedProductPageHeaderText,
				"Products page not loaded");
		assertEquals(productPage.getProductPageCreateProductButtonText(), expectedCreateProductButtonText,
				"Products page not loaded");
	}

	// @Test
	public void verifyCreateProductPageDisplay() {
		String expectedCreateProductPageHeaderText = "Create Product";
		Login login = new Login(driver);
		HomePage homePage = login.loginFunction("bibin", "Bibin@123");
		homePage.clickInventoryMenuModule();
		ProductPage productPage = homePage.clickProductOption();
		CreateProductPage createProductPage = productPage.clickCreateProduct();
		assertEquals(createProductPage.getCreateProductPageDisplayText(), expectedCreateProductPageHeaderText,
				"Create Product page not loaded");
		assertEquals(createProductPage.getCreateProductBreadCrumbText(), expectedCreateProductPageHeaderText,
				"Create Product page not loaded");
	}

	// @Test
	public void verifyNameFieldValidation() {
		String nameNullExpectedMessage = "Name cannot be blank.";
		Login login = new Login(driver);
		HomePage homePage = login.loginFunction("bibin", "Bibin@123");
		homePage.clickInventoryMenuModule();
		ProductPage productPage = homePage.clickProductOption();
		CreateProductPage createProductPage = productPage.clickCreateProduct();
		createProductPage.ClickOnSaveButton();
		assertEquals(createProductPage.getNameFieldValidationMessage(), nameNullExpectedMessage, "Name is entered");
	}

	// @Test
	public void verifyProductCreation() {
		String expectedProductPageHeaderText = "Products";
		Login login = new Login(driver);
		HomePage homePage = login.loginFunction("bibin", "Bibin@123");
		homePage.clickInventoryMenuModule();
		ProductPage productPage = homePage.clickProductOption();
		CreateProductPage createProductPage = productPage.clickCreateProduct();
		createProductPage.enterNameofProduct();// needs to change the hardcoded
												// ones to parameter one
		createProductPage.enterUnitofProduct();
		createProductPage.ClickOnSaveButton();
		assertEquals(productPage.getProductPageDisplayText(), expectedProductPageHeaderText, "Product not created");
	}

	// @Test
	public void verifySupplierPage() {
		String expectedSupplierPageHeaderText = "Suppliers";
		String expectedCreateSupplierButton = "Create Supplier";
		Login login = new Login(driver);
		HomePage homePage = login.loginFunction("bibin", "Bibin@123");
		homePage.clickInventoryMenuModule();
		SupplierPage supplierPage = homePage.clickSupplierOption();
		assertEquals(supplierPage.getSupplierPageDisplayText(), expectedSupplierPageHeaderText,
				"Suppliers page not loaded");
		assertEquals(supplierPage.getSupplierPageCreateSupplierText(), expectedCreateSupplierButton,
				"Suppliers page not loaded");
	}

	// @Test
	public void verifyViewSupplierPage() {
		String expectedViewSupplierPageHeaderText = "View Supplier";
		Login login = new Login(driver);
		HomePage homePage = login.loginFunction("bibin", "Bibin@123");
		homePage.clickInventoryMenuModule();
		SupplierPage supplierPage = homePage.clickSupplierOption();
		ViewSupplier viewSupplier = supplierPage.clickViewSupplierOption();
		assertEquals(viewSupplier.getViewSupplierPageHeaderText(), expectedViewSupplierPageHeaderText,
				"View Supplier Page not Loaded");
	}

	// @Test
	public void verifyUpdateSupplierPage() {
		Login login = new Login(driver);
		String expectedUpdateSupplierPageHeaderText = "Update Supplier";
		HomePage homePage = login.loginFunction("bibin", "Bibin@123");
		homePage.clickInventoryMenuModule();
		SupplierPage supplierPage = homePage.clickSupplierOption();
		UpdateSupplier updateSupplier = supplierPage.clickUpdateSupplierButton();
		assertEquals(updateSupplier.getUpdateSupplierPageHeaderText(), expectedUpdateSupplierPageHeaderText,
				"Update Supplier Page not Loaded");
	}

	//@Test
	public void verifyRosPageDisplay() {
		String expectedRosPageHeaderText = "Ros";
		String expectedRosPageCreateRosButton = "Create Ro";
		Login login = new Login(driver);
		HomePage homePage = login.loginFunction("bibin", "Bibin@123");
		homePage.clickInventoryMenuModule();
		RosPage rosPage = homePage.clickRosOption();
		assertEquals(rosPage.getRosPageDisplayText(), expectedRosPageHeaderText, "Ros Page not Loaded");
		assertEquals(rosPage.getRosPageCreateRoButtonText(), expectedRosPageCreateRosButton, "Ros Page not Loaded");
	}

	@Test

	
	  public void verifyLoginWithValidCred() throws InterruptedException
	  
	  {
	  
	  // Reading the data from excel file by the specified path
	  
	  String xl = "C:\\Users\\user\\workspace\\qabible-test\\src\\test\\resources\\details.xlsx";
	 
	  String Sheet = "User details";
	  String exptdashtext = "ERP | Dashboard";
	  int rowCount = ExcelUtility.getRowCount(xl, Sheet);
	  System.out.println(rowCount);
	  
	  for (int i = 1; i <= rowCount; i++)
	  
	  {
	  
	  String UserName = ExcelUtility.getCellValue(xl, Sheet, i, 0);
	  
	  String Pwd = ExcelUtility.getCellValue(xl, Sheet, i, 1);
	  
	  // Passing Username and password as parameters
	  
	  Login login = new Login(driver);
	  
	  HomePage homePage = login.loginFunction(UserName, Pwd);
	  String actdashtext = homePage.getHomePageHeaderText();
		assertEquals(actdashtext, exptdashtext, "Dashboard not loaded.. ...");
		System.out.println("Dashboard loaded!!");
		homePage.ClickOnProfileIcon();
		homePage.ClickOnLogout();
	  } 
	}
	 

	//@Test
	/*public void VerifyValidLogin() throws EncryptedDocumentException, IOException {
		String path = "C:\\Users\\user\\workspace\\qabible-test\\src\\test\\resources\\details.xlsx";

		String Sheet = "User details";

		String exptdashtext = "ERP | Dashboard";
		String actdashtext;
		ExcelUtility excelUtility = new ExcelUtility();
		int rowCount = excelUtility.getRowCount(path, Sheet);
		System.out.println(rowCount);
		for (int i = 1; i <= rowCount; i++)

		{

			String UserName = excelUtility.getCellValue(path, Sheet, i, 0);

			String Pwd = excelUtility.getCellValue(path, Sheet, i, 1);
			Login login = new Login(driver);
			HomePage homePage = login.loginFunction(UserName, Pwd);
			// Passing Username and password as parameters

			System.out.println("Username is" + UserName);
			System.out.println("Password is" + Pwd);
			if ((UserName.equals("bibin")) && (Pwd.equals("Bibin@123"))) {

				actdashtext = homePage.getHomePageHeaderText();
				assertEquals(actdashtext, exptdashtext, "Dashboard not loaded.. ...");
				System.out.println("Dashboard loaded!!");
				// ExcelUtillity.setStatus(path1, Sheet, i, 2, "Passing");
				excelUtility.ExcelWrite(path, Sheet, i, 2, "Pass");
				homePage.ClickOnProfileIcon();
				homePage.ClickOnLogout();
			}
			// login.IsLogged(path, Sheet, i);
			else {

				String expterrormesssage = "Please fix the following errors:";
				String acterrormessage = login.getErrorMessage();
				System.out.println("Actual error mesage is " + acterrormessage);
				assertEquals(acterrormessage, expterrormesssage, "Not Logged in");
				excelUtility.ExcelWrite(path, Sheet, i, 2, "Fail");

			}
		}
	}*/
}
