package HerokuApp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.annotations.Until;

public class P8FileUpload {

	static WebDriver driver;
	static WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
        driver = new ChromeDriver();	
		wait = new WebDriverWait(driver, 30);
	}
	
	@Test
	public void mytest() {
		driver.get("https://the-internet.herokuapp.com/upload");
		WebElement fileuploader = driver.findElement(By.xpath("//input[@id='file-upload']"));
		fileuploader.sendKeys("C:\\vcredist.bmp");
		WebElement btnUPload  = driver.findElement(By.xpath("//input[@id='file-submit']"));
		btnUPload.click();
		By h3Uploaded = By.xpath("//h3[contains(text(),'File Uploaded')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(h3Uploaded));
		Assert.assertTrue(driver.findElement(h3Uploaded).isDisplayed());
		List l = new ArrayList<String>();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
