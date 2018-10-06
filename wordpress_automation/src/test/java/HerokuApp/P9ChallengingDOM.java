package HerokuApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P9ChallengingDOM {

	static WebDriver driver;
	static WebDriverWait wait;
	static List<String> tHeaderString;
	
	@BeforeMethod
	public void setUp() {
		
		driver = new ChromeDriver();	
		wait = new WebDriverWait(driver, 30);
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
	}
	
	Integer getColPos(List<String> tHeader,String text) {
		for(int i=0;i<tHeader.size();i++) {
			if(tHeader.get(i).equals(text)) {
				return i+1;
			}
		}
	
		return -1;
	}
	
	String getTableData(String Header, Integer Row) {
		
		
		List<WebElement> tHeader = driver.findElements(By.xpath("//table/thead/tr/th"));
		tHeaderString = new ArrayList<String>();
		
		for(int i=0;i<tHeader.size();i++) {
			tHeaderString.add(tHeader.get(i).getText());
		}
		
		return driver.findElement(By.xpath("//tr["+Row+"]/td["+getColPos(tHeaderString, Header)+"]")).getText();
		
	}
	
	@Test
	public void test() {
	
		System.out.println(getTableData("Sit", 4));
		
	}
}
