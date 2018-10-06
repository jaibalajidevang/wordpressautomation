package HerokuApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P6Checkboxes {
	static WebDriver driver;
	static WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		
	}
	
	@Test
	public void test() {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		List<WebElement> l = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
		for(WebElement w:l) {
			w.click();
			System.out.println(w.isSelected());
		}
	}

}
