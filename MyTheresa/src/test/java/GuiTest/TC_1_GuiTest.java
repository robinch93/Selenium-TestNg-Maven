package GuiTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_1_GuiTest {

	public String baseUrl = "https://www.mytheresa.com/en-it/";
	public WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browserName) {
		
		if(browserName.equalsIgnoreCase("firefox")) {
			System.out.println("Launching Firefox Browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("chrome")) {
			System.out.println("Launching Chrome Browser");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new ChromeDriver(options);
		}else if (browserName.equalsIgnoreCase("IE")) {
			System.out.println("Launching IE Browser");
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testSearch() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[title='Men']")).click();
		Thread.sleep(9000);
		handlePopUp();
		driver.findElement(By.xpath("//input[@id=\"search\"]")).sendKeys("Gucci Bags", Keys.ENTER);	
		Thread.sleep(5000);
		handleSignup();
		String labelText = driver.findElement(By.xpath("//div[@class=\"search-result-intro\"]//p")).getText();
		System.out.println("Recieved Text is: " + labelText);
		assertTrue(labelText.equalsIgnoreCase("Search results for 'Gucci Bags'"));
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	public void handlePopUp() {	
		try {
			List<WebElement> buttons = driver.findElements(By.cssSelector("#acc-alert-close"));
			if(buttons.size() > 0) {
				System.out.println("Alert was found");
				buttons.get(0).click();
			}
		} catch (NullPointerException e) {
		}
	}
	
	public void handleSignup() {
		try {
			List<WebElement> buttons = driver.findElements(By.xpath("(//div[@id=\"CRCL-MNO1\"]//a)[1]"));
			for (int i = 0; i < buttons.size(); i++) {
				System.err.println("sign up was found");
				WebElement button = buttons.get(i);
				if (button.isEnabled()) {
					button.click();
					break;
				}
			}
		} catch (NullPointerException e) {
		}
	}
}
