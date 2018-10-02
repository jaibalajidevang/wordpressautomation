package HerokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P5FoatingMenu {

	static WebDriver driver;
	static WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		
	}
	
	@Test
	void regression() {
		
		driver.get("https://the-internet.herokuapp.com/floating_menu");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("scroll(0, 2200);");
		
		WebElement lnk_News = driver.findElement(By.xpath("//a[contains(text(),'News')]"));
		
		Assert.assertTrue(lnk_News.isDisplayed(), "Element is not displayed");
	}
}
