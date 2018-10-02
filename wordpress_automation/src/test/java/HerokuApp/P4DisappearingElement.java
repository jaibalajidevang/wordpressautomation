package HerokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P4DisappearingElement {

	static WebDriver driver;
	static WebDriverWait wait;
	static String username = "admin";
	static String password = "admin";
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		
	}
	static boolean elementsDisplayed(WebElement ... a) {
		
		boolean flag = true;
		
		for(WebElement x:a) {
			
			System.out.println(x.getText());
			
			if(!x.isDisplayed() && !x.isEnabled()) {
				flag = false;
			}
		}
		return flag;
		
	}
	
	@Test
	void regression() {
		
		driver.get("https://the-internet.herokuapp.com/disappearing_elements");
		
		WebElement lnk_Home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		WebElement lnk_About = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		WebElement lnk_ContactUs = driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]"));
		WebElement lnk_Portfolio = driver.findElement(By.xpath("//a[contains(text(),'Portfolio')]"));
		WebElement lnk_Gallery = driver.findElement(By.xpath("//a[contains(text(),'Gallery')]"));
	
		Assert.assertTrue(elementsDisplayed(lnk_Home,lnk_About,lnk_ContactUs,lnk_Portfolio,lnk_Gallery));
	}
}
