package scripts;

import java.io.File;
import java.io.FileNotFoundException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.GenericUtility;
import utilities.NotepadUtility;

public class TestHelper {
	public WebDriver driver;

	public void openBrowser(String browser1) {
		if (browser1.equals("chrome")) {
			// System.out.println("beforeMethod"+browser1);
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser1.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser1.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Enter a browser to run the script");
		}
	}

	@BeforeMethod
	public void beforeTest() throws FileNotFoundException {
		openBrowser("chrome");
		String path = "C:\\Users\\user\\workspace\\qabible-test\\src\\test\\resources\\qaenvironment";
		String data = NotepadUtility.readNotepadContent(path);
		driver.get(data);
	}

	@AfterMethod
	 public void tearDown (ITestResult result)
	    {
	        if (ITestResult.FAILURE == result.getStatus()) {
	            try {
	                TakesScreenshot ts = (TakesScreenshot) driver;
	                File source = ts.getScreenshotAs(OutputType.FILE);
	                GenericUtility.copyFileUsingStream(source, new File("./target/" + result.getName() + ".png"));
	                System.out.println("Screenshot taken");
	            } catch (Exception e) {
	                System.out.println("Exception while taking screenshot " + e.getMessage());
	            }
	        }
	        afterTest();
	    }
	public void afterTest() {
		driver.close();
	}
}
