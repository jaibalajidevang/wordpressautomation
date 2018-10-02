package HerokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.*;

public class P1AB_Test {

	@Test
	public void test1() {
		System.out.println("Called");
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://the-internet.herokuapp.com");
		
		WebElement heading = driver.findElement(By.xpath("//h1[@class = 'heading']"));
		
		Assert.assertEquals("Welcome to the-internet", heading.getText());
		
		WebElement abtest = driver.findElement(By.xpath("//a[(contains(text(), 'A/B Testing') or contains(., 'A/B Testing'))]"));
		
		abtest.click();
		
		By header = new By.ByXPath("//h3[(text() = 'A/B Test Control' or . = 'A/B Test Control')]");
		
		WebElement ele_header = wait.until(ExpectedConditions.presenceOfElementLocated(header));
		
		Assert.assertEquals(ele_header.getText(), "A/B Test Control");
	
		driver.quit();
	}
}
