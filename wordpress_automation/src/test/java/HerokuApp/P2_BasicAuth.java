package HerokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P2_BasicAuth {

	static WebDriver driver;
	static WebDriverWait wait;
	static String username = "admin";
	static String password = "admin";
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		
	}
	
	@Test
	public void login() {
		By msg = new By.ByXPath("//p[(contains(text(), 'Congratulations!'))]");
		driver.get("https://"+"admin"+":"+"admin"+"@"+"the-internet.herokuapp.com/basic_auth");
		WebElement ele_msg = wait.until(ExpectedConditions.visibilityOfElementLocated(msg));
		Assert.assertTrue(ele_msg.isDisplayed());
	}
	
	@Test
	public void login2() {
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		driver.switchTo().alert().sendKeys(username + Keys.TAB + password);
		driver.switchTo().alert().accept();
		By msg = new By.ByXPath("//p[(contains(text(), 'Congratulations!'))]");
		WebElement ele_msg = wait.until(ExpectedConditions.visibilityOfElementLocated(msg));
		Assert.assertTrue(ele_msg.isDisplayed());

	}
}
