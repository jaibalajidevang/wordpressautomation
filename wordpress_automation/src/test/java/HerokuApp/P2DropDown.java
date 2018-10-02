package HerokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P2DropDown {

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
	void test() {
		driver.get("https://the-internet.herokuapp.com/dropdown");
		
		WebElement sel = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select mydropdown = new Select(sel);
		
		//it will select based on value attribute
		mydropdown.selectByValue("2");
		
		// this will select based on value in select drop down
		mydropdown.selectByVisibleText("Option 1");
		
		// this will 
		mydropdown.selectByIndex(2);
		
		// this applies only when there is multi option is selected
		mydropdown.deselectByIndex(2);
		
		
	}
}
