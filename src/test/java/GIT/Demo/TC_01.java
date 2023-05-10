package GIT.Demo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01 {
	
	WebDriver driver;
	
	
	@BeforeSuite
	public void setUp() {
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setExperimentalOption("prefs", prefs);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		
	}
	
	@Test
	public void doLogin() {
		
		driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S1678764158%3A1683729064437697&authuser=0&continue=https%3A%2F%2Fmyaccount.google.com%2F&ec=GAlAwAE&hl=en&service=accountsettings&flowName=GlifWebSignIn&flowEntry=AddSession");
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("raju");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.quit();
	}

}
